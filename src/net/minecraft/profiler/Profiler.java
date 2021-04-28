package net.minecraft.profiler;

import java.util.*;
import org.apache.logging.log4j.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import com.google.common.collect.*;

public class Profiler
{
    private static final /* synthetic */ int HASH_PRE_RENDER_ERRORS;
    private static final /* synthetic */ int HASH_RENDER;
    private /* synthetic */ String profilingSection;
    private static final /* synthetic */ int HASH_TICK;
    private final /* synthetic */ List sectionList;
    private static final /* synthetic */ int HASH_SCHEDULED_EXECUTABLES;
    public /* synthetic */ boolean profilingEnabled;
    private static final /* synthetic */ Logger logger;
    private static final /* synthetic */ int HASH_DISPLAY;
    public /* synthetic */ boolean profilerGlobalEnabled;
    private final /* synthetic */ List timestampList;
    private final /* synthetic */ Map profilingMap;
    private /* synthetic */ boolean profilerLocalEnabled;
    
    public String getNameOfLastSection() {
        return (this.sectionList.size() == 0) ? "[UNKNOWN]" : this.sectionList.get(this.sectionList.size() - 1);
    }
    
    public List getProfilingData(String lllllllllllllllIlllllIllIllIIIlI) {
        this.profilerLocalEnabled = this.profilerGlobalEnabled;
        if (!this.profilerLocalEnabled) {
            return new ArrayList(Arrays.asList(new Result("root", 0.0, 0.0)));
        }
        if (!this.profilingEnabled) {
            return null;
        }
        long lllllllllllllllIlllllIllIlllIIIl = this.profilingMap.containsKey("root") ? this.profilingMap.get("root") : 0L;
        final long lllllllllllllllIlllllIllIlllIIII = this.profilingMap.containsKey(lllllllllllllllIlllllIllIllIIIlI) ? this.profilingMap.get(lllllllllllllllIlllllIllIllIIIlI) : -1L;
        final ArrayList lllllllllllllllIlllllIllIllIllll = Lists.newArrayList();
        if (lllllllllllllllIlllllIllIllIIIlI.length() > 0) {
            lllllllllllllllIlllllIllIllIIIlI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlllllIllIllIIIlI)).append("."));
        }
        long lllllllllllllllIlllllIllIllIlllI = 0L;
        for (final String lllllllllllllllIlllllIllIllIllII : this.profilingMap.keySet()) {
            if (lllllllllllllllIlllllIllIllIllII.length() > lllllllllllllllIlllllIllIllIIIlI.length() && lllllllllllllllIlllllIllIllIllII.startsWith(lllllllllllllllIlllllIllIllIIIlI) && lllllllllllllllIlllllIllIllIllII.indexOf(".", lllllllllllllllIlllllIllIllIIIlI.length() + 1) < 0) {
                lllllllllllllllIlllllIllIllIlllI += this.profilingMap.get(lllllllllllllllIlllllIllIllIllII);
            }
        }
        final float lllllllllllllllIlllllIllIllIlIll = (float)lllllllllllllllIlllllIllIllIlllI;
        if (lllllllllllllllIlllllIllIllIlllI < lllllllllllllllIlllllIllIlllIIII) {
            lllllllllllllllIlllllIllIllIlllI = lllllllllllllllIlllllIllIlllIIII;
        }
        if (lllllllllllllllIlllllIllIlllIIIl < lllllllllllllllIlllllIllIllIlllI) {
            lllllllllllllllIlllllIllIlllIIIl = lllllllllllllllIlllllIllIllIlllI;
        }
        for (final String lllllllllllllllIlllllIllIllIlIIl : this.profilingMap.keySet()) {
            if (lllllllllllllllIlllllIllIllIlIIl.length() > lllllllllllllllIlllllIllIllIIIlI.length() && lllllllllllllllIlllllIllIllIlIIl.startsWith(lllllllllllllllIlllllIllIllIIIlI) && lllllllllllllllIlllllIllIllIlIIl.indexOf(".", lllllllllllllllIlllllIllIllIIIlI.length() + 1) < 0) {
                final long lllllllllllllllIlllllIllIllIIlll = this.profilingMap.get(lllllllllllllllIlllllIllIllIlIIl);
                final double lllllllllllllllIlllllIllIllIIllI = lllllllllllllllIlllllIllIllIIlll * 100.0 / lllllllllllllllIlllllIllIllIlllI;
                final double lllllllllllllllIlllllIllIllIIlIl = lllllllllllllllIlllllIllIllIIlll * 100.0 / lllllllllllllllIlllllIllIlllIIIl;
                final String lllllllllllllllIlllllIllIllIIlII = lllllllllllllllIlllllIllIllIlIIl.substring(lllllllllllllllIlllllIllIllIIIlI.length());
                lllllllllllllllIlllllIllIllIllll.add(new Result(lllllllllllllllIlllllIllIllIIlII, lllllllllllllllIlllllIllIllIIllI, lllllllllllllllIlllllIllIllIIlIl));
            }
        }
        for (final String lllllllllllllllIlllllIllIllIlIII : this.profilingMap.keySet()) {
            this.profilingMap.put(lllllllllllllllIlllllIllIllIlIII, this.profilingMap.get(lllllllllllllllIlllllIllIllIlIII) * 950L / 1000L);
        }
        if (lllllllllllllllIlllllIllIllIlllI > lllllllllllllllIlllllIllIllIlIll) {
            lllllllllllllllIlllllIllIllIllll.add(new Result("unspecified", (lllllllllllllllIlllllIllIllIlllI - lllllllllllllllIlllllIllIllIlIll) * 100.0 / lllllllllllllllIlllllIllIllIlllI, (lllllllllllllllIlllllIllIllIlllI - lllllllllllllllIlllllIllIllIlIll) * 100.0 / lllllllllllllllIlllllIllIlllIIIl));
        }
        Collections.sort((List<Comparable>)lllllllllllllllIlllllIllIllIllll);
        lllllllllllllllIlllllIllIllIllll.add(0, new Result(lllllllllllllllIlllllIllIllIIIlI, 100.0, lllllllllllllllIlllllIllIllIlllI * 100.0 / lllllllllllllllIlllllIllIlllIIIl));
        return lllllllllllllllIlllllIllIllIllll;
    }
    
    static {
        DISPLAY = "display";
        SCHEDULED_EXECUTABLES = "scheduledExecutables";
        __OBFID = "CL_00001497";
        RENDER = "render";
        TICK = "tick";
        PRE_RENDER_ERRORS = "preRenderErrors";
        logger = LogManager.getLogger();
        HASH_SCHEDULED_EXECUTABLES = "scheduledExecutables".hashCode();
        HASH_TICK = "tick".hashCode();
        HASH_PRE_RENDER_ERRORS = "preRenderErrors".hashCode();
        HASH_RENDER = "render".hashCode();
        HASH_DISPLAY = "display".hashCode();
    }
    
    public void clearProfiling() {
        this.profilingMap.clear();
        this.profilingSection = "";
        this.sectionList.clear();
        this.profilerLocalEnabled = this.profilerGlobalEnabled;
    }
    
    public void startSection(final String lllllllllllllllIlllllIlllIIlIIll) {
        if (Lagometer.isActive()) {
            final int lllllllllllllllIlllllIlllIIlIIlI = lllllllllllllllIlllllIlllIIlIIll.hashCode();
            if (lllllllllllllllIlllllIlllIIlIIlI == Profiler.HASH_SCHEDULED_EXECUTABLES && lllllllllllllllIlllllIlllIIlIIll.equals("scheduledExecutables")) {
                Lagometer.timerScheduledExecutables.start();
            }
            else if (lllllllllllllllIlllllIlllIIlIIlI == Profiler.HASH_TICK && lllllllllllllllIlllllIlllIIlIIll.equals("tick") && Config.isMinecraftThread()) {
                Lagometer.timerScheduledExecutables.end();
                Lagometer.timerTick.start();
            }
            else if (lllllllllllllllIlllllIlllIIlIIlI == Profiler.HASH_PRE_RENDER_ERRORS && lllllllllllllllIlllllIlllIIlIIll.equals("preRenderErrors")) {
                Lagometer.timerTick.end();
            }
        }
        if (Config.isFastRender()) {
            final int lllllllllllllllIlllllIlllIIlIIIl = lllllllllllllllIlllllIlllIIlIIll.hashCode();
            if (lllllllllllllllIlllllIlllIIlIIIl == Profiler.HASH_RENDER && lllllllllllllllIlllllIlllIIlIIll.equals("render")) {
                GlStateManager.clearEnabled = false;
            }
            else if (lllllllllllllllIlllllIlllIIlIIIl == Profiler.HASH_DISPLAY && lllllllllllllllIlllllIlllIIlIIll.equals("display")) {
                GlStateManager.clearEnabled = true;
            }
        }
        if (this.profilerLocalEnabled && this.profilingEnabled) {
            if (this.profilingSection.length() > 0) {
                this.profilingSection = String.valueOf(new StringBuilder(String.valueOf(this.profilingSection)).append("."));
            }
            this.profilingSection = String.valueOf(new StringBuilder(String.valueOf(this.profilingSection)).append(lllllllllllllllIlllllIlllIIlIIll));
            this.sectionList.add(this.profilingSection);
            this.timestampList.add(System.nanoTime());
        }
    }
    
    public Profiler() {
        this.sectionList = Lists.newArrayList();
        this.timestampList = Lists.newArrayList();
        this.profilingSection = "";
        this.profilingMap = Maps.newHashMap();
        this.profilerGlobalEnabled = true;
        this.profilerLocalEnabled = this.profilerGlobalEnabled;
    }
    
    public void endSection() {
        if (this.profilerLocalEnabled && this.profilingEnabled) {
            final long lllllllllllllllIlllllIlllIIIlIII = System.nanoTime();
            final long lllllllllllllllIlllllIlllIIIIlll = this.timestampList.remove(this.timestampList.size() - 1);
            this.sectionList.remove(this.sectionList.size() - 1);
            final long lllllllllllllllIlllllIlllIIIIllI = lllllllllllllllIlllllIlllIIIlIII - lllllllllllllllIlllllIlllIIIIlll;
            if (this.profilingMap.containsKey(this.profilingSection)) {
                this.profilingMap.put(this.profilingSection, this.profilingMap.get(this.profilingSection) + lllllllllllllllIlllllIlllIIIIllI);
            }
            else {
                this.profilingMap.put(this.profilingSection, lllllllllllllllIlllllIlllIIIIllI);
            }
            if (lllllllllllllllIlllllIlllIIIIllI > 100000000L) {
                Profiler.logger.warn(String.valueOf(new StringBuilder("Something's taking too long! '").append(this.profilingSection).append("' took aprox ").append(lllllllllllllllIlllllIlllIIIIllI / 1000000.0).append(" ms")));
            }
            this.profilingSection = (this.sectionList.isEmpty() ? "" : this.sectionList.get(this.sectionList.size() - 1));
        }
    }
    
    public void endStartSection(final String lllllllllllllllIlllllIllIlIlIIII) {
        if (this.profilerLocalEnabled) {
            this.endSection();
            this.startSection(lllllllllllllllIlllllIllIlIlIIII);
        }
    }
    
    public static final class Result implements Comparable
    {
        public /* synthetic */ double field_76330_b;
        public /* synthetic */ double field_76332_a;
        public /* synthetic */ String field_76331_c;
        
        public int compareTo(final Result llllllllllllllIlIIIlllIlllIllIIl) {
            return (llllllllllllllIlIIIlllIlllIllIIl.field_76332_a < this.field_76332_a) ? -1 : ((llllllllllllllIlIIIlllIlllIllIIl.field_76332_a > this.field_76332_a) ? 1 : llllllllllllllIlIIIlllIlllIllIIl.field_76331_c.compareTo(this.field_76331_c));
        }
        
        public Result(final String llllllllllllllIlIIIlllIllllIIIIl, final double llllllllllllllIlIIIlllIllllIIIII, final double llllllllllllllIlIIIlllIlllIlllll) {
            this.field_76331_c = llllllllllllllIlIIIlllIllllIIIIl;
            this.field_76332_a = llllllllllllllIlIIIlllIllllIIIII;
            this.field_76330_b = llllllllllllllIlIIIlllIlllIlllll;
        }
        
        @Override
        public int compareTo(final Object llllllllllllllIlIIIlllIlllIlIIlI) {
            return this.compareTo((Result)llllllllllllllIlIIIlllIlllIlIIlI);
        }
        
        public int func_76329_a() {
            return (this.field_76331_c.hashCode() & 0xAAAAAA) + 4473924;
        }
    }
}
