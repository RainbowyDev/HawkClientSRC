package net.minecraft.util;

import net.minecraft.crash.*;

public class ReportedException extends RuntimeException
{
    private final /* synthetic */ CrashReport theReportedExceptionCrashReport;
    
    @Override
    public Throwable getCause() {
        return this.theReportedExceptionCrashReport.getCrashCause();
    }
    
    public ReportedException(final CrashReport llllllllllllllIllllIIllIlllIIIII) {
        this.theReportedExceptionCrashReport = llllllllllllllIllllIIllIlllIIIII;
    }
    
    public CrashReport getCrashReport() {
        return this.theReportedExceptionCrashReport;
    }
    
    static {
        __OBFID = "CL_00001579";
    }
    
    @Override
    public String getMessage() {
        return this.theReportedExceptionCrashReport.getDescription();
    }
}
