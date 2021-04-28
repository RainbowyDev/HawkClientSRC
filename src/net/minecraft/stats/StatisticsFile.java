package net.minecraft.stats;

import net.minecraft.server.*;
import java.lang.reflect.*;
import org.apache.logging.log4j.*;
import org.apache.commons.io.*;
import java.io.*;
import com.google.gson.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class StatisticsFile extends StatFileWriter
{
    private final /* synthetic */ File field_150887_d;
    private final /* synthetic */ MinecraftServer field_150890_c;
    private final /* synthetic */ Set field_150888_e;
    private /* synthetic */ int field_150885_f;
    private /* synthetic */ boolean field_150886_g;
    private static final /* synthetic */ Logger logger;
    
    public Map func_150881_a(final String llllllllllllllllIIIIIIlIlIlIllII) {
        final JsonElement llllllllllllllllIIIIIIlIlIlIlIll = new JsonParser().parse(llllllllllllllllIIIIIIlIlIlIllII);
        if (!llllllllllllllllIIIIIIlIlIlIlIll.isJsonObject()) {
            return Maps.newHashMap();
        }
        final JsonObject llllllllllllllllIIIIIIlIlIlIlIlI = llllllllllllllllIIIIIIlIlIlIlIll.getAsJsonObject();
        final HashMap llllllllllllllllIIIIIIlIlIlIlIIl = Maps.newHashMap();
        for (final Map.Entry llllllllllllllllIIIIIIlIlIlIIlll : llllllllllllllllIIIIIIlIlIlIlIlI.entrySet()) {
            final StatBase llllllllllllllllIIIIIIlIlIlIIllI = StatList.getOneShotStat(llllllllllllllllIIIIIIlIlIlIIlll.getKey());
            if (llllllllllllllllIIIIIIlIlIlIIllI != null) {
                final TupleIntJsonSerializable llllllllllllllllIIIIIIlIlIlIIlIl = new TupleIntJsonSerializable();
                if (llllllllllllllllIIIIIIlIlIlIIlll.getValue().isJsonPrimitive() && llllllllllllllllIIIIIIlIlIlIIlll.getValue().getAsJsonPrimitive().isNumber()) {
                    llllllllllllllllIIIIIIlIlIlIIlIl.setIntegerValue(llllllllllllllllIIIIIIlIlIlIIlll.getValue().getAsInt());
                }
                else if (llllllllllllllllIIIIIIlIlIlIIlll.getValue().isJsonObject()) {
                    final JsonObject llllllllllllllllIIIIIIlIlIlIIlII = llllllllllllllllIIIIIIlIlIlIIlll.getValue().getAsJsonObject();
                    if (llllllllllllllllIIIIIIlIlIlIIlII.has("value") && llllllllllllllllIIIIIIlIlIlIIlII.get("value").isJsonPrimitive() && llllllllllllllllIIIIIIlIlIlIIlII.get("value").getAsJsonPrimitive().isNumber()) {
                        llllllllllllllllIIIIIIlIlIlIIlIl.setIntegerValue(llllllllllllllllIIIIIIlIlIlIIlII.getAsJsonPrimitive("value").getAsInt());
                    }
                    if (llllllllllllllllIIIIIIlIlIlIIlII.has("progress") && llllllllllllllllIIIIIIlIlIlIIllI.func_150954_l() != null) {
                        try {
                            final Constructor llllllllllllllllIIIIIIlIlIlIIIll = llllllllllllllllIIIIIIlIlIlIIllI.func_150954_l().getConstructor((Class[])new Class[0]);
                            final IJsonSerializable llllllllllllllllIIIIIIlIlIlIIIlI = llllllllllllllllIIIIIIlIlIlIIIll.newInstance(new Object[0]);
                            llllllllllllllllIIIIIIlIlIlIIIlI.func_152753_a(llllllllllllllllIIIIIIlIlIlIIlII.get("progress"));
                            llllllllllllllllIIIIIIlIlIlIIlIl.setJsonSerializableValue(llllllllllllllllIIIIIIlIlIlIIIlI);
                        }
                        catch (Throwable llllllllllllllllIIIIIIlIlIlIIIIl) {
                            StatisticsFile.logger.warn(String.valueOf(new StringBuilder("Invalid statistic progress in ").append(this.field_150887_d)), llllllllllllllllIIIIIIlIlIlIIIIl);
                        }
                    }
                }
                llllllllllllllllIIIIIIlIlIlIlIIl.put(llllllllllllllllIIIIIIlIlIlIIllI, llllllllllllllllIIIIIIlIlIlIIlIl);
            }
            else {
                StatisticsFile.logger.warn(String.valueOf(new StringBuilder("Invalid statistic in ").append(this.field_150887_d).append(": Don't know what ").append(llllllllllllllllIIIIIIlIlIlIIlll.getKey()).append(" is")));
            }
        }
        return llllllllllllllllIIIIIIlIlIlIlIIl;
    }
    
    static {
        __OBFID = "CL_00001471";
        logger = LogManager.getLogger();
    }
    
    public void func_150882_a() {
        if (this.field_150887_d.isFile()) {
            try {
                this.field_150875_a.clear();
                this.field_150875_a.putAll(this.func_150881_a(FileUtils.readFileToString(this.field_150887_d)));
            }
            catch (IOException llllllllllllllllIIIIIIlIllIllIII) {
                StatisticsFile.logger.error(String.valueOf(new StringBuilder("Couldn't read statistics file ").append(this.field_150887_d)), (Throwable)llllllllllllllllIIIIIIlIllIllIII);
            }
            catch (JsonParseException llllllllllllllllIIIIIIlIllIlIlll) {
                StatisticsFile.logger.error(String.valueOf(new StringBuilder("Couldn't parse statistics file ").append(this.field_150887_d)), (Throwable)llllllllllllllllIIIIIIlIllIlIlll);
            }
        }
    }
    
    public StatisticsFile(final MinecraftServer llllllllllllllllIIIIIIlIlllIIIII, final File llllllllllllllllIIIIIIlIllIlllII) {
        this.field_150888_e = Sets.newHashSet();
        this.field_150885_f = -300;
        this.field_150886_g = false;
        this.field_150890_c = llllllllllllllllIIIIIIlIlllIIIII;
        this.field_150887_d = llllllllllllllllIIIIIIlIllIlllII;
    }
    
    public void func_150877_d() {
        for (final StatBase llllllllllllllllIIIIIIlIIlllllIl : this.field_150875_a.keySet()) {
            this.field_150888_e.add(llllllllllllllllIIIIIIlIIlllllIl);
        }
    }
    
    public void func_150883_b() {
        try {
            FileUtils.writeStringToFile(this.field_150887_d, func_150880_a(this.field_150875_a));
        }
        catch (IOException llllllllllllllllIIIIIIlIllIlIIIl) {
            StatisticsFile.logger.error("Couldn't save stats", (Throwable)llllllllllllllllIIIIIIlIllIlIIIl);
        }
    }
    
    public Set func_150878_c() {
        final HashSet llllllllllllllllIIIIIIlIlIllllII = Sets.newHashSet((Iterable)this.field_150888_e);
        this.field_150888_e.clear();
        this.field_150886_g = false;
        return llllllllllllllllIIIIIIlIlIllllII;
    }
    
    public void func_150876_a(final EntityPlayerMP llllllllllllllllIIIIIIlIIlllIIlI) {
        final int llllllllllllllllIIIIIIlIIlllIIIl = this.field_150890_c.getTickCounter();
        final HashMap llllllllllllllllIIIIIIlIIlllIIII = Maps.newHashMap();
        if (this.field_150886_g || llllllllllllllllIIIIIIlIIlllIIIl - this.field_150885_f > 300) {
            this.field_150885_f = llllllllllllllllIIIIIIlIIlllIIIl;
            for (final StatBase llllllllllllllllIIIIIIlIIllIlllI : this.func_150878_c()) {
                llllllllllllllllIIIIIIlIIlllIIII.put(llllllllllllllllIIIIIIlIIllIlllI, this.writeStat(llllllllllllllllIIIIIIlIIllIlllI));
            }
        }
        llllllllllllllllIIIIIIlIIlllIIlI.playerNetServerHandler.sendPacket(new S37PacketStatistics(llllllllllllllllIIIIIIlIIlllIIII));
    }
    
    public boolean func_150879_e() {
        return this.field_150886_g;
    }
    
    @Override
    public void func_150873_a(final EntityPlayer llllllllllllllllIIIIIIlIllIIlIII, final StatBase llllllllllllllllIIIIIIlIllIIIlll, final int llllllllllllllllIIIIIIlIllIIIIIl) {
        final int llllllllllllllllIIIIIIlIllIIIlIl = llllllllllllllllIIIIIIlIllIIIlll.isAchievement() ? this.writeStat(llllllllllllllllIIIIIIlIllIIIlll) : 0;
        super.func_150873_a(llllllllllllllllIIIIIIlIllIIlIII, llllllllllllllllIIIIIIlIllIIIlll, llllllllllllllllIIIIIIlIllIIIIIl);
        this.field_150888_e.add(llllllllllllllllIIIIIIlIllIIIlll);
        if (llllllllllllllllIIIIIIlIllIIIlll.isAchievement() && llllllllllllllllIIIIIIlIllIIIlIl == 0 && llllllllllllllllIIIIIIlIllIIIIIl > 0) {
            this.field_150886_g = true;
            if (this.field_150890_c.isAnnouncingPlayerAchievements()) {
                this.field_150890_c.getConfigurationManager().sendChatMsg(new ChatComponentTranslation("chat.type.achievement", new Object[] { llllllllllllllllIIIIIIlIllIIlIII.getDisplayName(), llllllllllllllllIIIIIIlIllIIIlll.func_150955_j() }));
            }
        }
        if (llllllllllllllllIIIIIIlIllIIIlll.isAchievement() && llllllllllllllllIIIIIIlIllIIIlIl > 0 && llllllllllllllllIIIIIIlIllIIIIIl == 0) {
            this.field_150886_g = true;
            if (this.field_150890_c.isAnnouncingPlayerAchievements()) {
                this.field_150890_c.getConfigurationManager().sendChatMsg(new ChatComponentTranslation("chat.type.achievement.taken", new Object[] { llllllllllllllllIIIIIIlIllIIlIII.getDisplayName(), llllllllllllllllIIIIIIlIllIIIlll.func_150955_j() }));
            }
        }
    }
    
    public static String func_150880_a(final Map llllllllllllllllIIIIIIlIlIIIlIII) {
        final JsonObject llllllllllllllllIIIIIIlIlIIIllIl = new JsonObject();
        for (final Map.Entry llllllllllllllllIIIIIIlIlIIIlIll : llllllllllllllllIIIIIIlIlIIIlIII.entrySet()) {
            if (llllllllllllllllIIIIIIlIlIIIlIll.getValue().getJsonSerializableValue() != null) {
                final JsonObject llllllllllllllllIIIIIIlIlIIIlIlI = new JsonObject();
                llllllllllllllllIIIIIIlIlIIIlIlI.addProperty("value", (Number)llllllllllllllllIIIIIIlIlIIIlIll.getValue().getIntegerValue());
                try {
                    llllllllllllllllIIIIIIlIlIIIlIlI.add("progress", llllllllllllllllIIIIIIlIlIIIlIll.getValue().getJsonSerializableValue().getSerializableElement());
                }
                catch (Throwable llllllllllllllllIIIIIIlIlIIIlIIl) {
                    StatisticsFile.logger.warn(String.valueOf(new StringBuilder("Couldn't save statistic ").append(llllllllllllllllIIIIIIlIlIIIlIll.getKey().getStatName()).append(": error serializing progress")), llllllllllllllllIIIIIIlIlIIIlIIl);
                }
                llllllllllllllllIIIIIIlIlIIIllIl.add(llllllllllllllllIIIIIIlIlIIIlIll.getKey().statId, (JsonElement)llllllllllllllllIIIIIIlIlIIIlIlI);
            }
            else {
                llllllllllllllllIIIIIIlIlIIIllIl.addProperty(llllllllllllllllIIIIIIlIlIIIlIll.getKey().statId, (Number)llllllllllllllllIIIIIIlIlIIIlIll.getValue().getIntegerValue());
            }
        }
        return llllllllllllllllIIIIIIlIlIIIllIl.toString();
    }
    
    public void func_150884_b(final EntityPlayerMP llllllllllllllllIIIIIIlIIlIlllII) {
        final HashMap llllllllllllllllIIIIIIlIIllIIIII = Maps.newHashMap();
        for (final Achievement llllllllllllllllIIIIIIlIIlIllllI : AchievementList.achievementList) {
            if (this.hasAchievementUnlocked(llllllllllllllllIIIIIIlIIlIllllI)) {
                llllllllllllllllIIIIIIlIIllIIIII.put(llllllllllllllllIIIIIIlIIlIllllI, this.writeStat(llllllllllllllllIIIIIIlIIlIllllI));
                this.field_150888_e.remove(llllllllllllllllIIIIIIlIIlIllllI);
            }
        }
        llllllllllllllllIIIIIIlIIlIlllII.playerNetServerHandler.sendPacket(new S37PacketStatistics(llllllllllllllllIIIIIIlIIllIIIII));
    }
}
