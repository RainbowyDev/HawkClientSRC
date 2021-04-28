package net.minecraft.crash;

import net.minecraft.util.*;
import org.apache.commons.io.*;
import java.util.concurrent.*;
import java.lang.management.*;
import net.minecraft.world.gen.layer.*;
import java.io.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import org.apache.commons.lang3.*;
import optifine.*;
import java.text.*;
import java.util.*;

public class CrashReport
{
    private final /* synthetic */ Throwable cause;
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ boolean reported;
    private final /* synthetic */ CrashReportCategory theReportCategory;
    private final /* synthetic */ String description;
    private /* synthetic */ StackTraceElement[] stacktrace;
    private final /* synthetic */ List crashReportSections;
    private /* synthetic */ boolean field_85059_f;
    private /* synthetic */ File crashReportFile;
    
    public CrashReportCategory makeCategory(final String llllllllllllllIlIIlllllllIIllIll) {
        return this.makeCategoryDepth(llllllllllllllIlIIlllllllIIllIll, 1);
    }
    
    public static CrashReport makeCrashReport(final Throwable llllllllllllllIlIIllllllIllIllll, final String llllllllllllllIlIIllllllIlllIIlI) {
        CrashReport llllllllllllllIlIIllllllIlllIIII = null;
        if (llllllllllllllIlIIllllllIllIllll instanceof ReportedException) {
            final CrashReport llllllllllllllIlIIllllllIlllIIIl = ((ReportedException)llllllllllllllIlIIllllllIllIllll).getCrashReport();
        }
        else {
            llllllllllllllIlIIllllllIlllIIII = new CrashReport(llllllllllllllIlIIllllllIlllIIlI, llllllllllllllIlIIllllllIllIllll);
        }
        return llllllllllllllIlIIllllllIlllIIII;
    }
    
    public File getFile() {
        return this.crashReportFile;
    }
    
    public String getCauseStackTraceOrString() {
        StringWriter llllllllllllllIlIIllllllllIIIIll = null;
        PrintWriter llllllllllllllIlIIllllllllIIIIlI = null;
        Object llllllllllllllIlIIllllllllIIIIIl = this.cause;
        if (((Throwable)llllllllllllllIlIIllllllllIIIIIl).getMessage() == null) {
            if (llllllllllllllIlIIllllllllIIIIIl instanceof NullPointerException) {
                llllllllllllllIlIIllllllllIIIIIl = new NullPointerException(this.description);
            }
            else if (llllllllllllllIlIIllllllllIIIIIl instanceof StackOverflowError) {
                llllllllllllllIlIIllllllllIIIIIl = new StackOverflowError(this.description);
            }
            else if (llllllllllllllIlIIllllllllIIIIIl instanceof OutOfMemoryError) {
                llllllllllllllIlIIllllllllIIIIIl = new OutOfMemoryError(this.description);
            }
            ((Throwable)llllllllllllllIlIIllllllllIIIIIl).setStackTrace(this.cause.getStackTrace());
        }
        String llllllllllllllIlIIllllllllIIIIII = ((Throwable)llllllllllllllIlIIllllllllIIIIIl).toString();
        try {
            llllllllllllllIlIIllllllllIIIIll = new StringWriter();
            llllllllllllllIlIIllllllllIIIIlI = new PrintWriter(llllllllllllllIlIIllllllllIIIIll);
            ((Throwable)llllllllllllllIlIIllllllllIIIIIl).printStackTrace(llllllllllllllIlIIllllllllIIIIlI);
            llllllllllllllIlIIllllllllIIIIII = llllllllllllllIlIIllllllllIIIIll.toString();
        }
        finally {
            IOUtils.closeQuietly((Writer)llllllllllllllIlIIllllllllIIIIll);
            IOUtils.closeQuietly((Writer)llllllllllllllIlIIllllllllIIIIlI);
        }
        IOUtils.closeQuietly((Writer)llllllllllllllIlIIllllllllIIIIll);
        IOUtils.closeQuietly((Writer)llllllllllllllIlIIllllllllIIIIlI);
        return llllllllllllllIlIIllllllllIIIIII;
    }
    
    private void populateEnvironment() {
        this.theReportCategory.addCrashSectionCallable("Minecraft Version", new Callable() {
            @Override
            public String call() {
                return "1.8";
            }
            
            static {
                __OBFID = "CL_00001197";
            }
        });
        this.theReportCategory.addCrashSectionCallable("Operating System", new Callable() {
            static {
                __OBFID = "CL_00001222";
            }
            
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(System.getProperty("os.name"))).append(" (").append(System.getProperty("os.arch")).append(") version ").append(System.getProperty("os.version")));
            }
        });
        this.theReportCategory.addCrashSectionCallable("Java Version", new Callable() {
            static {
                __OBFID = "CL_00001248";
            }
            
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(System.getProperty("java.version"))).append(", ").append(System.getProperty("java.vendor")));
            }
        });
        this.theReportCategory.addCrashSectionCallable("Java VM Version", new Callable() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(System.getProperty("java.vm.name"))).append(" (").append(System.getProperty("java.vm.info")).append("), ").append(System.getProperty("java.vm.vendor")));
            }
            
            static {
                __OBFID = "CL_00001275";
            }
        });
        this.theReportCategory.addCrashSectionCallable("Memory", new Callable() {
            @Override
            public String call() {
                final Runtime lllllllllllllllllllIlllIlIIlllIl = Runtime.getRuntime();
                final long lllllllllllllllllllIlllIlIIlllII = lllllllllllllllllllIlllIlIIlllIl.maxMemory();
                final long lllllllllllllllllllIlllIlIIllIll = lllllllllllllllllllIlllIlIIlllIl.totalMemory();
                final long lllllllllllllllllllIlllIlIIllIlI = lllllllllllllllllllIlllIlIIlllIl.freeMemory();
                final long lllllllllllllllllllIlllIlIIllIIl = lllllllllllllllllllIlllIlIIlllII / 1024L / 1024L;
                final long lllllllllllllllllllIlllIlIIllIII = lllllllllllllllllllIlllIlIIllIll / 1024L / 1024L;
                final long lllllllllllllllllllIlllIlIIlIlll = lllllllllllllllllllIlllIlIIllIlI / 1024L / 1024L;
                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllllIlllIlIIllIlI)).append(" bytes (").append(lllllllllllllllllllIlllIlIIlIlll).append(" MB) / ").append(lllllllllllllllllllIlllIlIIllIll).append(" bytes (").append(lllllllllllllllllllIlllIlIIllIII).append(" MB) up to ").append(lllllllllllllllllllIlllIlIIlllII).append(" bytes (").append(lllllllllllllllllllIlllIlIIllIIl).append(" MB)"));
            }
            
            static {
                __OBFID = "CL_00001302";
            }
        });
        this.theReportCategory.addCrashSectionCallable("JVM Flags", new Callable() {
            @Override
            public String call() {
                final RuntimeMXBean llllllllllllllIIlIIlllIlIllIIIlI = ManagementFactory.getRuntimeMXBean();
                final List llllllllllllllIIlIIlllIlIllIIIIl = llllllllllllllIIlIIlllIlIllIIIlI.getInputArguments();
                int llllllllllllllIIlIIlllIlIllIIIII = 0;
                final StringBuilder llllllllllllllIIlIIlllIlIlIlllll = new StringBuilder();
                for (final String llllllllllllllIIlIIlllIlIlIlllIl : llllllllllllllIIlIIlllIlIllIIIIl) {
                    if (llllllllllllllIIlIIlllIlIlIlllIl.startsWith("-X")) {
                        if (llllllllllllllIIlIIlllIlIllIIIII++ > 0) {
                            llllllllllllllIIlIIlllIlIlIlllll.append(" ");
                        }
                        llllllllllllllIIlIIlllIlIlIlllll.append(llllllllllllllIIlIIlllIlIlIlllIl);
                    }
                }
                return String.format("%d total; %s", llllllllllllllIIlIIlllIlIllIIIII, String.valueOf(llllllllllllllIIlIIlllIlIlIlllll));
            }
            
            static {
                __OBFID = "CL_00001329";
            }
        });
        this.theReportCategory.addCrashSectionCallable("IntCache", new Callable() {
            static {
                __OBFID = "CL_00001355";
            }
            
            @Override
            public String call() {
                return IntCache.getCacheSizes();
            }
        });
        if (Reflector.FMLCommonHandler_enhanceCrashReport.exists()) {
            final Object llllllllllllllIlIIlllllllllIIlll = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            Reflector.callString(llllllllllllllIlIIlllllllllIIlll, Reflector.FMLCommonHandler_enhanceCrashReport, this, this.theReportCategory);
        }
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public Throwable getCrashCause() {
        return this.cause;
    }
    
    public boolean saveToFile(final File llllllllllllllIlIIlllllllIlIIlIl) {
        if (this.crashReportFile != null) {
            return false;
        }
        if (llllllllllllllIlIIlllllllIlIIlIl.getParentFile() != null) {
            llllllllllllllIlIIlllllllIlIIlIl.getParentFile().mkdirs();
        }
        try {
            final FileWriter llllllllllllllIlIIlllllllIlIlIII = new FileWriter(llllllllllllllIlIIlllllllIlIIlIl);
            llllllllllllllIlIIlllllllIlIlIII.write(this.getCompleteReport());
            llllllllllllllIlIIlllllllIlIlIII.close();
            this.crashReportFile = llllllllllllllIlIIlllllllIlIIlIl;
            return true;
        }
        catch (Throwable llllllllllllllIlIIlllllllIlIIlll) {
            CrashReport.logger.error(String.valueOf(new StringBuilder("Could not save crash report to ").append(llllllllllllllIlIIlllllllIlIIlIl)), llllllllllllllIlIIlllllllIlIIlll);
            return false;
        }
    }
    
    static {
        __OBFID = "CL_00000990";
        logger = LogManager.getLogger();
    }
    
    public CrashReport(final String llllllllllllllIlIIlllllllllIllII, final Throwable llllllllllllllIlIIlllllllllIlllI) {
        this.theReportCategory = new CrashReportCategory(this, "System Details");
        this.crashReportSections = Lists.newArrayList();
        this.field_85059_f = true;
        this.stacktrace = new StackTraceElement[0];
        this.reported = false;
        this.description = llllllllllllllIlIIlllllllllIllII;
        this.cause = llllllllllllllIlIIlllllllllIlllI;
        this.populateEnvironment();
    }
    
    private static String getWittyComment() {
        final String[] llllllllllllllIlIIllllllIllllIlI = { "Who set us up the TNT?", "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3", "I just don't know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn't worry myself about that.", "I bet Cylons wouldn't have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!", "Why is it breaking :(", "Don't do that.", "Ouch. That hurt :(", "You're mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!", "But it works on my machine." };
        try {
            return llllllllllllllIlIIllllllIllllIlI[(int)(System.nanoTime() % llllllllllllllIlIIllllllIllllIlI.length)];
        }
        catch (Throwable llllllllllllllIlIIllllllIllllIIl) {
            return "Witty comment unavailable :(";
        }
    }
    
    public CrashReportCategory getCategory() {
        return this.theReportCategory;
    }
    
    public void getSectionsInStringBuilder(final StringBuilder llllllllllllllIlIIllllllllIIllll) {
        if ((this.stacktrace == null || this.stacktrace.length <= 0) && this.crashReportSections.size() > 0) {
            this.stacktrace = (StackTraceElement[])ArrayUtils.subarray((Object[])this.crashReportSections.get(0).getStackTrace(), 0, 1);
        }
        if (this.stacktrace != null && this.stacktrace.length > 0) {
            llllllllllllllIlIIllllllllIIllll.append("-- Head --\n");
            llllllllllllllIlIIllllllllIIllll.append("Stacktrace:\n");
            for (final StackTraceElement llllllllllllllIlIIllllllllIlIIll : this.stacktrace) {
                llllllllllllllIlIIllllllllIIllll.append("\t").append("at ").append(llllllllllllllIlIIllllllllIlIIll.toString());
                llllllllllllllIlIIllllllllIIllll.append("\n");
            }
            llllllllllllllIlIIllllllllIIllll.append("\n");
        }
        for (final CrashReportCategory llllllllllllllIlIIllllllllIlIIIl : this.crashReportSections) {
            llllllllllllllIlIIllllllllIlIIIl.appendToStringBuilder(llllllllllllllIlIIllllllllIIllll);
            llllllllllllllIlIIllllllllIIllll.append("\n\n");
        }
        this.theReportCategory.appendToStringBuilder(llllllllllllllIlIIllllllllIIllll);
    }
    
    public CrashReportCategory makeCategoryDepth(final String llllllllllllllIlIIlllllllIIIllll, final int llllllllllllllIlIIlllllllIIIIlII) {
        final CrashReportCategory llllllllllllllIlIIlllllllIIIllIl = new CrashReportCategory(this, llllllllllllllIlIIlllllllIIIllll);
        if (this.field_85059_f) {
            final int llllllllllllllIlIIlllllllIIIllII = llllllllllllllIlIIlllllllIIIllIl.getPrunedStackTrace(llllllllllllllIlIIlllllllIIIIlII);
            final StackTraceElement[] llllllllllllllIlIIlllllllIIIlIll = this.cause.getStackTrace();
            StackTraceElement llllllllllllllIlIIlllllllIIIlIlI = null;
            StackTraceElement llllllllllllllIlIIlllllllIIIlIIl = null;
            final int llllllllllllllIlIIlllllllIIIlIII = llllllllllllllIlIIlllllllIIIlIll.length - llllllllllllllIlIIlllllllIIIllII;
            if (llllllllllllllIlIIlllllllIIIlIII < 0) {
                System.out.println(String.valueOf(new StringBuilder("Negative index in crash report handler (").append(llllllllllllllIlIIlllllllIIIlIll.length).append("/").append(llllllllllllllIlIIlllllllIIIllII).append(")")));
            }
            if (llllllllllllllIlIIlllllllIIIlIll != null && llllllllllllllIlIIlllllllIIIlIII >= 0 && llllllllllllllIlIIlllllllIIIlIII < llllllllllllllIlIIlllllllIIIlIll.length) {
                llllllllllllllIlIIlllllllIIIlIlI = llllllllllllllIlIIlllllllIIIlIll[llllllllllllllIlIIlllllllIIIlIII];
                if (llllllllllllllIlIIlllllllIIIlIll.length + 1 - llllllllllllllIlIIlllllllIIIllII < llllllllllllllIlIIlllllllIIIlIll.length) {
                    llllllllllllllIlIIlllllllIIIlIIl = llllllllllllllIlIIlllllllIIIlIll[llllllllllllllIlIIlllllllIIIlIll.length + 1 - llllllllllllllIlIIlllllllIIIllII];
                }
            }
            this.field_85059_f = llllllllllllllIlIIlllllllIIIllIl.firstTwoElementsOfStackTraceMatch(llllllllllllllIlIIlllllllIIIlIlI, llllllllllllllIlIIlllllllIIIlIIl);
            if (llllllllllllllIlIIlllllllIIIllII > 0 && !this.crashReportSections.isEmpty()) {
                final CrashReportCategory llllllllllllllIlIIlllllllIIIIlll = this.crashReportSections.get(this.crashReportSections.size() - 1);
                llllllllllllllIlIIlllllllIIIIlll.trimStackTraceEntriesFromBottom(llllllllllllllIlIIlllllllIIIllII);
            }
            else if (llllllllllllllIlIIlllllllIIIlIll != null && llllllllllllllIlIIlllllllIIIlIll.length >= llllllllllllllIlIIlllllllIIIllII && llllllllllllllIlIIlllllllIIIlIII >= 0 && llllllllllllllIlIIlllllllIIIlIII < llllllllllllllIlIIlllllllIIIlIll.length) {
                this.stacktrace = new StackTraceElement[llllllllllllllIlIIlllllllIIIlIII];
                System.arraycopy(llllllllllllllIlIIlllllllIIIlIll, 0, this.stacktrace, 0, this.stacktrace.length);
            }
            else {
                this.field_85059_f = false;
            }
        }
        this.crashReportSections.add(llllllllllllllIlIIlllllllIIIllIl);
        return llllllllllllllIlIIlllllllIIIllIl;
    }
    
    public String getCompleteReport() {
        if (!this.reported) {
            this.reported = true;
            CrashReporter.onCrashReport(this, this.theReportCategory);
        }
        final StringBuilder llllllllllllllIlIIlllllllIllIlIl = new StringBuilder();
        llllllllllllllIlIIlllllllIllIlIl.append("---- Minecraft Crash Report ----\n");
        Reflector.call(Reflector.BlamingTransformer_onCrash, llllllllllllllIlIIlllllllIllIlIl);
        Reflector.call(Reflector.CoreModManager_onCrash, llllllllllllllIlIIlllllllIllIlIl);
        llllllllllllllIlIIlllllllIllIlIl.append("// ");
        llllllllllllllIlIIlllllllIllIlIl.append(getWittyComment());
        llllllllllllllIlIIlllllllIllIlIl.append("\n\n");
        llllllllllllllIlIIlllllllIllIlIl.append("Time: ");
        llllllllllllllIlIIlllllllIllIlIl.append(new SimpleDateFormat().format(new Date()));
        llllllllllllllIlIIlllllllIllIlIl.append("\n");
        llllllllllllllIlIIlllllllIllIlIl.append("Description: ");
        llllllllllllllIlIIlllllllIllIlIl.append(this.description);
        llllllllllllllIlIIlllllllIllIlIl.append("\n\n");
        llllllllllllllIlIIlllllllIllIlIl.append(this.getCauseStackTraceOrString());
        llllllllllllllIlIIlllllllIllIlIl.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");
        for (int llllllllllllllIlIIlllllllIllIlII = 0; llllllllllllllIlIIlllllllIllIlII < 87; ++llllllllllllllIlIIlllllllIllIlII) {
            llllllllllllllIlIIlllllllIllIlIl.append("-");
        }
        llllllllllllllIlIIlllllllIllIlIl.append("\n\n");
        this.getSectionsInStringBuilder(llllllllllllllIlIIlllllllIllIlIl);
        return String.valueOf(llllllllllllllIlIIlllllllIllIlIl);
    }
}
