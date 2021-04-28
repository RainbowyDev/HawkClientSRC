package net.minecraft.client.audio;

import net.minecraft.server.gui.*;
import net.minecraft.client.*;
import java.util.*;
import net.minecraft.util.*;

public class MusicTicker implements IUpdatePlayerListBox
{
    private /* synthetic */ int timeUntilNextMusic;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ ISound currentMusic;
    private final /* synthetic */ Random rand;
    
    @Override
    public void update() {
        final MusicType llllllllllllllllIIlIlIllIIIlIIll = this.mc.getAmbientMusicType();
        if (this.currentMusic != null) {
            if (!llllllllllllllllIIlIlIllIIIlIIll.getMusicLocation().equals(this.currentMusic.getSoundLocation())) {
                this.mc.getSoundHandler().stopSound(this.currentMusic);
                this.timeUntilNextMusic = MathHelper.getRandomIntegerInRange(this.rand, 0, llllllllllllllllIIlIlIllIIIlIIll.getMinDelay() / 2);
            }
            if (!this.mc.getSoundHandler().isSoundPlaying(this.currentMusic)) {
                this.currentMusic = null;
                this.timeUntilNextMusic = Math.min(MathHelper.getRandomIntegerInRange(this.rand, llllllllllllllllIIlIlIllIIIlIIll.getMinDelay(), llllllllllllllllIIlIlIllIIIlIIll.getMaxDelay()), this.timeUntilNextMusic);
            }
        }
        if (this.currentMusic == null && this.timeUntilNextMusic-- <= 0) {
            this.currentMusic = PositionedSoundRecord.createPositionedSoundRecord(llllllllllllllllIIlIlIllIIIlIIll.getMusicLocation());
            this.mc.getSoundHandler().playSound(this.currentMusic);
            this.timeUntilNextMusic = Integer.MAX_VALUE;
        }
    }
    
    static {
        __OBFID = "CL_00001138";
    }
    
    public MusicTicker(final Minecraft llllllllllllllllIIlIlIllIIIlIlll) {
        this.rand = new Random();
        this.timeUntilNextMusic = 100;
        this.mc = llllllllllllllllIIlIlIllIIIlIlll;
    }
    
    public enum MusicType
    {
        CREATIVE("CREATIVE", 2, "CREATIVE", 2, new ResourceLocation("minecraft:music.game.creative"), 1200, 3600), 
        MENU("MENU", 0, "MENU", 0, new ResourceLocation("minecraft:music.menu"), 20, 600);
        
        private final /* synthetic */ ResourceLocation musicLocation;
        
        GAME("GAME", 1, "GAME", 1, new ResourceLocation("minecraft:music.game"), 12000, 24000), 
        END("END", 6, "END", 6, new ResourceLocation("minecraft:music.game.end"), 6000, 24000);
        
        private final /* synthetic */ int maxDelay;
        private final /* synthetic */ int minDelay;
        
        CREDITS("CREDITS", 3, "CREDITS", 3, new ResourceLocation("minecraft:music.game.end.credits"), Integer.MAX_VALUE, Integer.MAX_VALUE), 
        END_BOSS("END_BOSS", 5, "END_BOSS", 5, new ResourceLocation("minecraft:music.game.end.dragon"), 0, 0), 
        NETHER("NETHER", 4, "NETHER", 4, new ResourceLocation("minecraft:music.game.nether"), 1200, 3600);
        
        public int getMaxDelay() {
            return this.maxDelay;
        }
        
        public ResourceLocation getMusicLocation() {
            return this.musicLocation;
        }
        
        private MusicType(final String llIIlllIlllllI, final int llIIlllIllllIl, final String llIIllllIIIlII, final int llIIllllIIIIll, final ResourceLocation llIIlllIllllII, final int llIIllllIIIIIl, final int llIIlllIlllIlI) {
            this.musicLocation = llIIlllIllllII;
            this.minDelay = llIIllllIIIIIl;
            this.maxDelay = llIIlllIlllIlI;
        }
        
        static {
            __OBFID = "CL_00001139";
        }
        
        public int getMinDelay() {
            return this.minDelay;
        }
    }
}
