package net.minecraft.client.audio;

import java.util.*;
import com.google.common.collect.*;

public class SoundList
{
    private /* synthetic */ boolean replaceExisting;
    private final /* synthetic */ List soundList;
    private /* synthetic */ SoundCategory category;
    
    public void setSoundCategory(final SoundCategory lllllllllllllllIlIlIIIIllllllIlI) {
        this.category = lllllllllllllllIlIlIIIIllllllIlI;
    }
    
    public SoundList() {
        this.soundList = Lists.newArrayList();
    }
    
    public boolean canReplaceExisting() {
        return this.replaceExisting;
    }
    
    public void setReplaceExisting(final boolean lllllllllllllllIlIlIIIlIIIIIIIIl) {
        this.replaceExisting = lllllllllllllllIlIlIIIlIIIIIIIIl;
    }
    
    static {
        __OBFID = "CL_00001121";
    }
    
    public SoundCategory getSoundCategory() {
        return this.category;
    }
    
    public List getSoundList() {
        return this.soundList;
    }
    
    public static class SoundEntry
    {
        private /* synthetic */ Type field_148566_e;
        private /* synthetic */ float volume;
        private /* synthetic */ float pitch;
        private /* synthetic */ String name;
        private /* synthetic */ int field_148565_d;
        private /* synthetic */ boolean field_148564_f;
        
        static {
            __OBFID = "CL_00001122";
        }
        
        public void setSoundEntryType(final Type lllllllllllllllllIIIllIllllIIlII) {
            this.field_148566_e = lllllllllllllllllIIIllIllllIIlII;
        }
        
        public void setSoundEntryVolume(final float lllllllllllllllllIIIllIlllllllIl) {
            this.volume = lllllllllllllllllIIIllIlllllllIl;
        }
        
        public int getSoundEntryWeight() {
            return this.field_148565_d;
        }
        
        public boolean isStreaming() {
            return this.field_148564_f;
        }
        
        public void setSoundEntryPitch(final float lllllllllllllllllIIIllIlllllIlII) {
            this.pitch = lllllllllllllllllIIIllIlllllIlII;
        }
        
        public SoundEntry() {
            this.volume = 1.0f;
            this.pitch = 1.0f;
            this.field_148565_d = 1;
            this.field_148566_e = Type.FILE;
            this.field_148564_f = false;
        }
        
        public Type getSoundEntryType() {
            return this.field_148566_e;
        }
        
        public void setSoundEntryName(final String lllllllllllllllllIIIlllIIIIIlIII) {
            this.name = lllllllllllllllllIIIlllIIIIIlIII;
        }
        
        public float getSoundEntryVolume() {
            return this.volume;
        }
        
        public void setStreaming(final boolean lllllllllllllllllIIIllIlllIllIll) {
            this.field_148564_f = lllllllllllllllllIIIllIlllIllIll;
        }
        
        public String getSoundEntryName() {
            return this.name;
        }
        
        public void setSoundEntryWeight(final int lllllllllllllllllIIIllIllllIllIl) {
            this.field_148565_d = lllllllllllllllllIIIllIllllIllIl;
        }
        
        public float getSoundEntryPitch() {
            return this.pitch;
        }
        
        public enum Type
        {
            FILE("FILE", 0, "FILE", 0, "file"), 
            SOUND_EVENT("SOUND_EVENT", 1, "SOUND_EVENT", 1, "event");
            
            private final /* synthetic */ String field_148583_c;
            
            static {
                __OBFID = "CL_00001123";
            }
            
            private Type(final String llllllllllllllllIIIIlIllIIIIIIII, final int llllllllllllllllIIIIlIlIllllllll, final String llllllllllllllllIIIIlIllIIIIIlII, final int llllllllllllllllIIIIlIllIIIIIIll, final String llllllllllllllllIIIIlIlIlllllllI) {
                this.field_148583_c = llllllllllllllllIIIIlIlIlllllllI;
            }
            
            public static Type getType(final String llllllllllllllllIIIIlIlIlllllIII) {
                for (final Type llllllllllllllllIIIIlIlIllllIlII : values()) {
                    if (llllllllllllllllIIIIlIlIllllIlII.field_148583_c.equals(llllllllllllllllIIIIlIlIlllllIII)) {
                        return llllllllllllllllIIIIlIlIllllIlII;
                    }
                }
                return null;
            }
        }
    }
}
