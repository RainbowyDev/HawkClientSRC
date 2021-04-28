package net.minecraft.command;

public class SyntaxErrorException extends CommandException
{
    static {
        __OBFID = "CL_00001189";
    }
    
    public SyntaxErrorException(final String llllllllllllllIIlIIlIlIIIllIIIIl, final Object... llllllllllllllIIlIIlIlIIIllIIIII) {
        super(llllllllllllllIIlIIlIlIIIllIIIIl, llllllllllllllIIlIIlIlIIIllIIIII);
    }
    
    public SyntaxErrorException() {
        this("commands.generic.snytax", new Object[0]);
    }
}
