package net.minecraft.crash;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import java.util.concurrent.*;
import net.minecraft.block.*;
import com.google.common.collect.*;

public class CrashReportCategory
{
    private final /* synthetic */ CrashReport theCrashReport;
    private final /* synthetic */ String name;
    private /* synthetic */ StackTraceElement[] stackTrace;
    private final /* synthetic */ List children;
    
    public int getPrunedStackTrace(final int lllIlIIIIlIIlI) {
        final StackTraceElement[] lllIlIIIIlIlII = Thread.currentThread().getStackTrace();
        if (lllIlIIIIlIlII.length <= 0) {
            return 0;
        }
        this.stackTrace = new StackTraceElement[lllIlIIIIlIlII.length - 3 - lllIlIIIIlIIlI];
        System.arraycopy(lllIlIIIIlIlII, 3 + lllIlIIIIlIIlI, this.stackTrace, 0, this.stackTrace.length);
        return this.stackTrace.length;
    }
    
    public boolean firstTwoElementsOfStackTraceMatch(final StackTraceElement lllIlIIIIIIlll, final StackTraceElement lllIlIIIIIIllI) {
        if (this.stackTrace.length == 0 || lllIlIIIIIIlll == null) {
            return false;
        }
        final StackTraceElement lllIlIIIIIlIIl = this.stackTrace[0];
        if (lllIlIIIIIlIIl.isNativeMethod() != lllIlIIIIIIlll.isNativeMethod() || !lllIlIIIIIlIIl.getClassName().equals(lllIlIIIIIIlll.getClassName()) || !lllIlIIIIIlIIl.getFileName().equals(lllIlIIIIIIlll.getFileName()) || !lllIlIIIIIlIIl.getMethodName().equals(lllIlIIIIIIlll.getMethodName())) {
            return false;
        }
        if (lllIlIIIIIIllI != null != this.stackTrace.length > 1) {
            return false;
        }
        if (lllIlIIIIIIllI != null && !this.stackTrace[1].equals(lllIlIIIIIIllI)) {
            return false;
        }
        this.stackTrace[0] = lllIlIIIIIIlll;
        return true;
    }
    
    public void trimStackTraceEntriesFromBottom(final int lllIlIIIIIIIII) {
        final StackTraceElement[] lllIIlllllllll = new StackTraceElement[this.stackTrace.length - lllIlIIIIIIIII];
        System.arraycopy(this.stackTrace, 0, lllIIlllllllll, 0, lllIIlllllllll.length);
        this.stackTrace = lllIIlllllllll;
    }
    
    public void appendToStringBuilder(final StringBuilder lllIIllllIlIll) {
        lllIIllllIlIll.append("-- ").append(this.name).append(" --\n");
        lllIIllllIlIll.append("Details:");
        for (final Entry lllIIlllllIIIl : this.children) {
            lllIIllllIlIll.append("\n\t");
            lllIIllllIlIll.append(lllIIlllllIIIl.getKey());
            lllIIllllIlIll.append(": ");
            lllIIllllIlIll.append(lllIIlllllIIIl.getValue());
        }
        if (this.stackTrace != null && this.stackTrace.length > 0) {
            lllIIllllIlIll.append("\nStacktrace:");
            for (final StackTraceElement lllIIllllIllIl : this.stackTrace) {
                lllIIllllIlIll.append("\n\tat ");
                lllIIllllIlIll.append(lllIIllllIllIl.toString());
            }
        }
    }
    
    public static void addBlockInfo(final CrashReportCategory lllIIlllIIllIl, final BlockPos lllIIlllIIllII, final IBlockState lllIIlllIIlIll) {
        lllIIlllIIllIl.addCrashSectionCallable("Block", new Callable() {
            static {
                __OBFID = "CL_00002617";
            }
            
            public String func_175753_a() {
                return lllIIlllIIlIll.toString();
            }
            
            @Override
            public Object call() {
                return this.func_175753_a();
            }
        });
        lllIIlllIIllIl.addCrashSectionCallable("Block location", new Callable() {
            public String func_175751_a() {
                return CrashReportCategory.getCoordinateInfo(lllIIlllIIllII);
            }
            
            @Override
            public Object call() {
                return this.func_175751_a();
            }
            
            static {
                __OBFID = "CL_00002616";
            }
        });
    }
    
    public void addCrashSection(final String lllIlIIIlIIlII, final Object lllIlIIIlIIllI) {
        this.children.add(new Entry(lllIlIIIlIIlII, lllIlIIIlIIllI));
    }
    
    static {
        __OBFID = "CL_00001409";
    }
    
    public static void addBlockInfo(final CrashReportCategory lllIIlllIllIII, final BlockPos lllIIlllIlIlll, final Block lllIIlllIllIll, final int lllIIlllIllIlI) {
        final int lllIIlllIllIIl = Block.getIdFromBlock(lllIIlllIllIll);
        lllIIlllIllIII.addCrashSectionCallable("Block type", new Callable() {
            @Override
            public String call() {
                try {
                    return String.format("ID #%d (%s // %s)", lllIIlllIllIIl, lllIIlllIllIll.getUnlocalizedName(), lllIIlllIllIll.getClass().getCanonicalName());
                }
                catch (Throwable llllllllllllllIIIIIIIlIIlIllllII) {
                    return String.valueOf(new StringBuilder("ID #").append(lllIIlllIllIIl));
                }
            }
            
            static {
                __OBFID = "CL_00001426";
            }
        });
        lllIIlllIllIII.addCrashSectionCallable("Block data value", new Callable() {
            static {
                __OBFID = "CL_00001441";
            }
            
            @Override
            public String call() {
                if (lllIIlllIllIlI < 0) {
                    return String.valueOf(new StringBuilder("Unknown? (Got ").append(lllIIlllIllIlI).append(")"));
                }
                final String llllllllllllllIIlIIIIIIlIIIIlIII = String.format("%4s", Integer.toBinaryString(lllIIlllIllIlI)).replace(" ", "0");
                return String.format("%1$d / 0x%1$X / 0b%2$s", lllIIlllIllIlI, llllllllllllllIIlIIIIIIlIIIIlIII);
            }
        });
        lllIIlllIllIII.addCrashSectionCallable("Block location", new Callable() {
            static {
                __OBFID = "CL_00001465";
            }
            
            @Override
            public String call() {
                return CrashReportCategory.getCoordinateInfo(lllIIlllIlIlll);
            }
        });
    }
    
    public static String getCoordinateInfo(final BlockPos lllIlIIllIIIIl) {
        final int lllIlIIllIIIII = lllIlIIllIIIIl.getX();
        final int lllIlIIlIlllll = lllIlIIllIIIIl.getY();
        final int lllIlIIlIllllI = lllIlIIllIIIIl.getZ();
        final StringBuilder lllIlIIlIlllIl = new StringBuilder();
        try {
            lllIlIIlIlllIl.append(String.format("World: (%d,%d,%d)", lllIlIIllIIIII, lllIlIIlIlllll, lllIlIIlIllllI));
        }
        catch (Throwable lllIlIIlIlllII) {
            lllIlIIlIlllIl.append("(Error finding world loc)");
        }
        lllIlIIlIlllIl.append(", ");
        try {
            final int lllIlIIlIllIll = lllIlIIllIIIII >> 4;
            final int lllIlIIlIllIIl = lllIlIIlIllllI >> 4;
            final int lllIlIIlIlIlll = lllIlIIllIIIII & 0xF;
            final int lllIlIIlIlIlIl = lllIlIIlIlllll >> 4;
            final int lllIlIIlIlIIll = lllIlIIlIllllI & 0xF;
            final int lllIlIIlIlIIIl = lllIlIIlIllIll << 4;
            final int lllIlIIlIIllll = lllIlIIlIllIIl << 4;
            final int lllIlIIlIIllIl = (lllIlIIlIllIll + 1 << 4) - 1;
            final int lllIlIIlIIlIll = (lllIlIIlIllIIl + 1 << 4) - 1;
            lllIlIIlIlllIl.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", lllIlIIlIlIlll, lllIlIIlIlIlIl, lllIlIIlIlIIll, lllIlIIlIllIll, lllIlIIlIllIIl, lllIlIIlIlIIIl, lllIlIIlIIllll, lllIlIIlIIllIl, lllIlIIlIIlIll));
        }
        catch (Throwable lllIlIIlIIlIIl) {
            lllIlIIlIlllIl.append("(Error finding chunk loc)");
        }
        lllIlIIlIlllIl.append(", ");
        try {
            final int lllIlIIlIllIlI = lllIlIIllIIIII >> 9;
            final int lllIlIIlIllIII = lllIlIIlIllllI >> 9;
            final int lllIlIIlIlIllI = lllIlIIlIllIlI << 5;
            final int lllIlIIlIlIlII = lllIlIIlIllIII << 5;
            final int lllIlIIlIlIIlI = (lllIlIIlIllIlI + 1 << 5) - 1;
            final int lllIlIIlIlIIII = (lllIlIIlIllIII + 1 << 5) - 1;
            final int lllIlIIlIIlllI = lllIlIIlIllIlI << 9;
            final int lllIlIIlIIllII = lllIlIIlIllIII << 9;
            final int lllIlIIlIIlIlI = (lllIlIIlIllIlI + 1 << 9) - 1;
            final int lllIlIIlIIlIII = (lllIlIIlIllIII + 1 << 9) - 1;
            lllIlIIlIlllIl.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", lllIlIIlIllIlI, lllIlIIlIllIII, lllIlIIlIlIllI, lllIlIIlIlIlII, lllIlIIlIlIIlI, lllIlIIlIlIIII, lllIlIIlIIlllI, lllIlIIlIIllII, lllIlIIlIIlIlI, lllIlIIlIIlIII));
        }
        catch (Throwable lllIlIIlIIIlll) {
            lllIlIIlIlllIl.append("(Error finding world loc)");
        }
        return String.valueOf(lllIlIIlIlllIl);
    }
    
    public void addCrashSectionThrowable(final String lllIlIIIIllIll, final Throwable lllIlIIIIllIlI) {
        this.addCrashSection(lllIlIIIIllIll, lllIlIIIIllIlI);
    }
    
    public void addCrashSectionCallable(final String lllIlIIIllIIlI, final Callable lllIlIIIllIIIl) {
        try {
            this.addCrashSection(lllIlIIIllIIlI, lllIlIIIllIIIl.call());
        }
        catch (Throwable lllIlIIIllIIII) {
            this.addCrashSectionThrowable(lllIlIIIllIIlI, lllIlIIIllIIII);
        }
    }
    
    public CrashReportCategory(final CrashReport lllIlIIllllllI, final String lllIlIIllllIlI) {
        this.children = Lists.newArrayList();
        this.stackTrace = new StackTraceElement[0];
        this.theCrashReport = lllIlIIllllllI;
        this.name = lllIlIIllllIlI;
    }
    
    public StackTraceElement[] getStackTrace() {
        return this.stackTrace;
    }
    
    public static String getCoordinateInfo(final double lllIlIIlllIIll, final double lllIlIIlllIlIl, final double lllIlIIlllIIIl) {
        return String.format("%.2f,%.2f,%.2f - %s", lllIlIIlllIIll, lllIlIIlllIlIl, lllIlIIlllIIIl, getCoordinateInfo(new BlockPos(lllIlIIlllIIll, lllIlIIlllIlIl, lllIlIIlllIIIl)));
    }
    
    static class Entry
    {
        private final /* synthetic */ String value;
        private final /* synthetic */ String key;
        
        static {
            __OBFID = "CL_00001489";
        }
        
        public String getKey() {
            return this.key;
        }
        
        public Entry(final String llllllllllllllllllIIlIlIIllllIlI, final Object llllllllllllllllllIIlIlIIllllIII) {
            this.key = llllllllllllllllllIIlIlIIllllIlI;
            if (llllllllllllllllllIIlIlIIllllIII == null) {
                this.value = "~~NULL~~";
            }
            else if (llllllllllllllllllIIlIlIIllllIII instanceof Throwable) {
                final Throwable llllllllllllllllllIIlIlIIllllllI = (Throwable)llllllllllllllllllIIlIlIIllllIII;
                this.value = String.valueOf(new StringBuilder("~~ERROR~~ ").append(llllllllllllllllllIIlIlIIllllllI.getClass().getSimpleName()).append(": ").append(llllllllllllllllllIIlIlIIllllllI.getMessage()));
            }
            else {
                this.value = llllllllllllllllllIIlIlIIllllIII.toString();
            }
        }
        
        public String getValue() {
            return this.value;
        }
    }
}
