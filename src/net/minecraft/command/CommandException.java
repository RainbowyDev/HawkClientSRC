package net.minecraft.command;

public class CommandException extends Exception
{
    private final /* synthetic */ Object[] errorObjects;
    
    public Object[] getErrorOjbects() {
        return this.errorObjects;
    }
    
    static {
        __OBFID = "CL_00001187";
    }
    
    public CommandException(final String llllllllllllllllIIIIlIlIIIlIlIll, final Object... llllllllllllllllIIIIlIlIIIlIllIl) {
        super(llllllllllllllllIIIIlIlIIIlIlIll);
        this.errorObjects = llllllllllllllllIIIIlIlIIIlIllIl;
    }
}
