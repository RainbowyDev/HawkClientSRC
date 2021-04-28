package optifine;

import net.minecraft.server.*;
import net.minecraft.world.storage.*;
import net.minecraft.profiler.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.world.*;

public class WorldServerOF extends WorldServer
{
    private /* synthetic */ MinecraftServer mcServer;
    
    @Override
    protected void updateWeather() {
        if (!Config.isWeatherEnabled()) {
            this.fixWorldWeather();
        }
        super.updateWeather();
    }
    
    private void fixWorldTime() {
        if (this.worldInfo.getGameType().getID() == 1) {
            final long llllllllllllllIIlIIIlIlIlIllIlIl = this.getWorldTime();
            final long llllllllllllllIIlIIIlIlIlIllIlII = llllllllllllllIIlIIIlIlIlIllIlIl % 24000L;
            if (Config.isTimeDayOnly()) {
                if (llllllllllllllIIlIIIlIlIlIllIlII <= 1000L) {
                    this.setWorldTime(llllllllllllllIIlIIIlIlIlIllIlIl - llllllllllllllIIlIIIlIlIlIllIlII + 1001L);
                }
                if (llllllllllllllIIlIIIlIlIlIllIlII >= 11000L) {
                    this.setWorldTime(llllllllllllllIIlIIIlIlIlIllIlIl - llllllllllllllIIlIIIlIlIlIllIlII + 24001L);
                }
            }
            if (Config.isTimeNightOnly()) {
                if (llllllllllllllIIlIIIlIlIlIllIlII <= 14000L) {
                    this.setWorldTime(llllllllllllllIIlIIIlIlIlIllIlIl - llllllllllllllIIlIIIlIlIlIllIlII + 14001L);
                }
                if (llllllllllllllIIlIIIlIlIlIllIlII >= 22000L) {
                    this.setWorldTime(llllllllllllllIIlIIIlIlIlIllIlIl - llllllllllllllIIlIIIlIlIlIllIlII + 24000L + 14001L);
                }
            }
        }
    }
    
    public WorldServerOF(final MinecraftServer llllllllllllllIIlIIIlIlIllIIIlll, final ISaveHandler llllllllllllllIIlIIIlIlIllIIllII, final WorldInfo llllllllllllllIIlIIIlIlIllIIlIll, final int llllllllllllllIIlIIIlIlIllIIlIlI, final Profiler llllllllllllllIIlIIIlIlIllIIIIll) {
        super(llllllllllllllIIlIIIlIlIllIIIlll, llllllllllllllIIlIIIlIlIllIIllII, llllllllllllllIIlIIIlIlIllIIlIll, llllllllllllllIIlIIIlIlIllIIlIlI, llllllllllllllIIlIIIlIlIllIIIIll);
        this.mcServer = llllllllllllllIIlIIIlIlIllIIIlll;
    }
    
    private void fixWorldWeather() {
        if (this.worldInfo.isRaining() || this.worldInfo.isThundering()) {
            this.worldInfo.setRainTime(0);
            this.worldInfo.setRaining(false);
            this.setRainStrength(0.0f);
            this.worldInfo.setThunderTime(0);
            this.worldInfo.setThundering(false);
            this.setThunderStrength(0.0f);
            this.mcServer.getConfigurationManager().sendPacketToAllPlayers(new S2BPacketChangeGameState(2, 0.0f));
            this.mcServer.getConfigurationManager().sendPacketToAllPlayers(new S2BPacketChangeGameState(7, 0.0f));
            this.mcServer.getConfigurationManager().sendPacketToAllPlayers(new S2BPacketChangeGameState(8, 0.0f));
        }
    }
    
    @Override
    public void tick() {
        super.tick();
        if (!Config.isTimeDefault()) {
            this.fixWorldTime();
        }
        if (Config.waterOpacityChanged) {
            Config.waterOpacityChanged = false;
            ClearWater.updateWaterOpacity(Config.getGameSettings(), this);
        }
    }
}
