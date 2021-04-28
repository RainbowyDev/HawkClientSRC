package shadersmod.common;

import java.util.*;
import java.util.logging.*;
import java.io.*;

public abstract class SMCLog
{
    public static final /* synthetic */ Level SMCFINEST;
    public static final /* synthetic */ Level SMCFINE;
    public static final /* synthetic */ Logger logger;
    public static final /* synthetic */ Level SMCFINER;
    public static final /* synthetic */ Level SMCINFO;
    public static final /* synthetic */ Level SMCCONFIG;
    
    public static void severe(final String llllllllllllllIIIIIllIIIIllllIII) {
        if (SMCLog.logger.isLoggable(Level.SEVERE)) {
            SMCLog.logger.log(Level.SEVERE, llllllllllllllIIIIIllIIIIllllIII);
        }
    }
    
    static {
        smcLogName = "SMC";
        logger = new SMCLogger("SMC");
        SMCINFO = new SMCLevel("INF", 850, (NamelessClass763038833)null);
        SMCCONFIG = new SMCLevel("CFG", 840, (NamelessClass763038833)null);
        SMCFINE = new SMCLevel("FNE", 830, (NamelessClass763038833)null);
        SMCFINER = new SMCLevel("FNR", 820, (NamelessClass763038833)null);
        SMCFINEST = new SMCLevel("FNT", 810, (NamelessClass763038833)null);
    }
    
    public static void config(final String llllllllllllllIIIIIllIIIIIlIllII, final Object... llllllllllllllIIIIIllIIIIIlIlllI) {
        if (SMCLog.logger.isLoggable(SMCLog.SMCCONFIG)) {
            SMCLog.logger.log(SMCLog.SMCCONFIG, String.format(llllllllllllllIIIIIllIIIIIlIllII, llllllllllllllIIIIIllIIIIIlIlllI));
        }
    }
    
    public static void warning(final String llllllllllllllIIIIIllIIIIlIIIlII, final Object... llllllllllllllIIIIIllIIIIlIIIIII) {
        if (SMCLog.logger.isLoggable(Level.WARNING)) {
            SMCLog.logger.log(Level.WARNING, String.format(llllllllllllllIIIIIllIIIIlIIIlII, llllllllllllllIIIIIllIIIIlIIIIII));
        }
    }
    
    public static void log(final Level llllllllllllllIIIIIllIIIIlIllIII, final String llllllllllllllIIIIIllIIIIlIlIllI, final Object... llllllllllllllIIIIIllIIIIlIllIlI) {
        if (SMCLog.logger.isLoggable(llllllllllllllIIIIIllIIIIlIllIII)) {
            SMCLog.logger.log(llllllllllllllIIIIIllIIIIlIllIII, String.format(llllllllllllllIIIIIllIIIIlIlIllI, llllllllllllllIIIIIllIIIIlIllIlI));
        }
    }
    
    public static void finest(final String llllllllllllllIIIIIllIIIIllIIllI) {
        if (SMCLog.logger.isLoggable(SMCLog.SMCFINEST)) {
            SMCLog.logger.log(SMCLog.SMCFINEST, llllllllllllllIIIIIllIIIIllIIllI);
        }
    }
    
    public static void config(final String llllllllllllllIIIIIllIIIIlllIIII) {
        if (SMCLog.logger.isLoggable(SMCLog.SMCCONFIG)) {
            SMCLog.logger.log(SMCLog.SMCCONFIG, llllllllllllllIIIIIllIIIIlllIIII);
        }
    }
    
    public static void warning(final String llllllllllllllIIIIIllIIIIlllIlIl) {
        if (SMCLog.logger.isLoggable(Level.WARNING)) {
            SMCLog.logger.log(Level.WARNING, llllllllllllllIIIIIllIIIIlllIlIl);
        }
    }
    
    public static void severe(final String llllllllllllllIIIIIllIIIIlIIlllI, final Object... llllllllllllllIIIIIllIIIIlIIlIll) {
        if (SMCLog.logger.isLoggable(Level.SEVERE)) {
            SMCLog.logger.log(Level.SEVERE, String.format(llllllllllllllIIIIIllIIIIlIIlllI, llllllllllllllIIIIIllIIIIlIIlIll));
        }
    }
    
    public static void finest(final String llllllllllllllIIIIIllIIIIIIlIllI, final Object... llllllllllllllIIIIIllIIIIIIlIlIl) {
        if (SMCLog.logger.isLoggable(SMCLog.SMCFINEST)) {
            SMCLog.logger.log(SMCLog.SMCFINEST, String.format(llllllllllllllIIIIIllIIIIIIlIllI, llllllllllllllIIIIIllIIIIIIlIlIl));
        }
    }
    
    public static void fine(final String llllllllllllllIIIIIllIIIIIlIIlIl, final Object... llllllllllllllIIIIIllIIIIIlIIlII) {
        if (SMCLog.logger.isLoggable(SMCLog.SMCFINE)) {
            SMCLog.logger.log(SMCLog.SMCFINE, String.format(llllllllllllllIIIIIllIIIIIlIIlIl, llllllllllllllIIIIIllIIIIIlIIlII));
        }
    }
    
    public static void fine(final String llllllllllllllIIIIIllIIIIllIllIl) {
        if (SMCLog.logger.isLoggable(SMCLog.SMCFINE)) {
            SMCLog.logger.log(SMCLog.SMCFINE, llllllllllllllIIIIIllIIIIllIllIl);
        }
    }
    
    public static void finer(final String llllllllllllllIIIIIllIIIIllIlIIl) {
        if (SMCLog.logger.isLoggable(SMCLog.SMCFINER)) {
            SMCLog.logger.log(SMCLog.SMCFINER, llllllllllllllIIIIIllIIIIllIlIIl);
        }
    }
    
    public static void log(final Level llllllllllllllIIIIIllIIIIlllllII, final String llllllllllllllIIIIIllIIIIlllllIl) {
        if (SMCLog.logger.isLoggable(llllllllllllllIIIIIllIIIIlllllII)) {
            SMCLog.logger.log(llllllllllllllIIIIIllIIIIlllllII, llllllllllllllIIIIIllIIIIlllllIl);
        }
    }
    
    public static void info(final String llllllllllllllIIIIIllIIIIIllIlll, final Object... llllllllllllllIIIIIllIIIIIllIlIl) {
        if (SMCLog.logger.isLoggable(SMCLog.SMCINFO)) {
            SMCLog.logger.log(SMCLog.SMCINFO, String.format(llllllllllllllIIIIIllIIIIIllIlll, llllllllllllllIIIIIllIIIIIllIlIl));
        }
    }
    
    public static void info(final String llllllllllllllIIIIIllIIIIlllIIll) {
        if (SMCLog.logger.isLoggable(SMCLog.SMCINFO)) {
            SMCLog.logger.log(SMCLog.SMCINFO, llllllllllllllIIIIIllIIIIlllIIll);
        }
    }
    
    public static void finer(final String llllllllllllllIIIIIllIIIIIIlllII, final Object... llllllllllllllIIIIIllIIIIIIlllIl) {
        if (SMCLog.logger.isLoggable(SMCLog.SMCFINER)) {
            SMCLog.logger.log(SMCLog.SMCFINER, String.format(llllllllllllllIIIIIllIIIIIIlllII, llllllllllllllIIIIIllIIIIIIlllIl));
        }
    }
    
    static class NamelessClass763038833
    {
    }
    
    private static class SMCLevel extends Level
    {
        private SMCLevel(final String lllllllllllllllIIlIlIIIIlIllIIIl, final int lllllllllllllllIIlIlIIIIlIllIIII) {
            super(lllllllllllllllIIlIlIIIIlIllIIIl, lllllllllllllllIIlIlIIIIlIllIIII);
        }
        
        SMCLevel(final String lllllllllllllllIIlIlIIIIlIIlllII, final int lllllllllllllllIIlIlIIIIlIIllIlI, final NamelessClass763038833 lllllllllllllllIIlIlIIIIlIIllllI) {
            this(lllllllllllllllIIlIlIIIIlIIlllII, lllllllllllllllIIlIlIIIIlIIllIlI);
        }
    }
    
    private static class SMCFormatter extends Formatter
    {
        /* synthetic */ int tzOffset;
        
        @Override
        public String format(final LogRecord lllllllllllllllIIIIllIlIlIIIIIIl) {
            final StringBuilder lllllllllllllllIIIIllIlIlIIIIIlI = new StringBuilder();
            lllllllllllllllIIIIllIlIlIIIIIlI.append("[");
            lllllllllllllllIIIIllIlIlIIIIIlI.append("Shaders").append("]");
            if (lllllllllllllllIIIIllIlIlIIIIIIl.getLevel() != SMCLog.SMCINFO) {
                lllllllllllllllIIIIllIlIlIIIIIlI.append("[").append(lllllllllllllllIIIIllIlIlIIIIIIl.getLevel()).append("]");
            }
            lllllllllllllllIIIIllIlIlIIIIIlI.append(" ");
            lllllllllllllllIIIIllIlIlIIIIIlI.append(lllllllllllllllIIIIllIlIlIIIIIIl.getMessage()).append("\n");
            return String.valueOf(lllllllllllllllIIIIllIlIlIIIIIlI);
        }
        
        private SMCFormatter() {
            this.tzOffset = Calendar.getInstance().getTimeZone().getRawOffset();
        }
    }
    
    private static class SMCLogger extends Logger
    {
        SMCLogger(final String lllllllllllllllIIIlIllIlIIllllll) {
            super(lllllllllllllllIIIlIllIlIIllllll, null);
            this.setUseParentHandlers(false);
            final SMCFormatter lllllllllllllllIIIlIllIlIlIIIlIl = new SMCFormatter(null);
            final ConsoleHandler lllllllllllllllIIIlIllIlIlIIIlII = new ConsoleHandler();
            lllllllllllllllIIIlIllIlIlIIIlII.setFormatter(lllllllllllllllIIIlIllIlIlIIIlIl);
            lllllllllllllllIIIlIllIlIlIIIlII.setLevel(Level.ALL);
            this.addHandler(lllllllllllllllIIIlIllIlIlIIIlII);
            try {
                final FileOutputStream lllllllllllllllIIIlIllIlIlIIIIll = new FileOutputStream("logs/shadersmod.log", false);
                final StreamHandler lllllllllllllllIIIlIllIlIlIIIIlI = new StreamHandler(lllllllllllllllIIIlIllIlIlIIIIll, lllllllllllllllIIIlIllIlIlIIIlIl) {
                    @Override
                    public synchronized void publish(final LogRecord lllllllllllllllllllIllIIlllIlIII) {
                        super.publish(lllllllllllllllllllIllIIlllIlIII);
                        this.flush();
                    }
                };
                lllllllllllllllIIIlIllIlIlIIIIlI.setFormatter(lllllllllllllllIIIlIllIlIlIIIlIl);
                lllllllllllllllIIIlIllIlIlIIIIlI.setLevel(Level.ALL);
                this.addHandler(lllllllllllllllIIIlIllIlIlIIIIlI);
            }
            catch (IOException lllllllllllllllIIIlIllIlIlIIIIIl) {
                lllllllllllllllIIIlIllIlIlIIIIIl.printStackTrace();
            }
            this.setLevel(Level.ALL);
        }
    }
}
