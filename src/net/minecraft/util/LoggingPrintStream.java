package net.minecraft.util;

import java.io.*;
import org.apache.logging.log4j.*;

public class LoggingPrintStream extends PrintStream
{
    private final /* synthetic */ String domain;
    private static final /* synthetic */ Logger LOGGER;
    
    public LoggingPrintStream(final String llllllllllllllllIIIIlllIIIIIllIl, final OutputStream llllllllllllllllIIIIlllIIIIIllll) {
        super(llllllllllllllllIIIIlllIIIIIllll);
        this.domain = llllllllllllllllIIIIlllIIIIIllIl;
    }
    
    @Override
    public void println(final Object llllllllllllllllIIIIllIllllllIII) {
        this.logString(String.valueOf(llllllllllllllllIIIIllIllllllIII));
    }
    
    static {
        __OBFID = "CL_00002275";
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void println(final String llllllllllllllllIIIIlllIIIIIlIII) {
        this.logString(llllllllllllllllIIIIlllIIIIIlIII);
    }
    
    private void logString(final String llllllllllllllllIIIIllIllllIlIlI) {
        final StackTraceElement[] llllllllllllllllIIIIllIllllIlIIl = Thread.currentThread().getStackTrace();
        final StackTraceElement llllllllllllllllIIIIllIllllIlIII = llllllllllllllllIIIIllIllllIlIIl[Math.min(3, llllllllllllllllIIIIllIllllIlIIl.length)];
        LoggingPrintStream.LOGGER.info("[{}]@.({}:{}): {}", new Object[] { this.domain, llllllllllllllllIIIIllIllllIlIII.getFileName(), llllllllllllllllIIIIllIllllIlIII.getLineNumber(), llllllllllllllllIIIIllIllllIlIlI });
    }
}
