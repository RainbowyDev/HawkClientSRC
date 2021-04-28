package net.minecraft.network;

public final class ThreadQuickExitException extends RuntimeException
{
    @Override
    public synchronized Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }
    
    static {
        __OBFID = "CL_00002274";
        field_179886_a = new ThreadQuickExitException();
    }
    
    private ThreadQuickExitException() {
        this.setStackTrace(new StackTraceElement[0]);
    }
}
