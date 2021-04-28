package net.minecraft.command;

public class NumberInvalidException extends CommandException
{
    public NumberInvalidException(final String llllllllllllllIlIlIlllllIIlllllI, final Object... llllllllllllllIlIlIlllllIIlllIlI) {
        super(llllllllllllllIlIlIlllllIIlllllI, llllllllllllllIlIlIlllllIIlllIlI);
    }
    
    static {
        __OBFID = "CL_00001188";
    }
    
    public NumberInvalidException() {
        this("commands.generic.num.invalid", new Object[0]);
    }
}
