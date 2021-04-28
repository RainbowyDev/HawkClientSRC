package net.minecraft.command;

public class CommandNotFoundException extends CommandException
{
    static {
        __OBFID = "CL_00001191";
    }
    
    public CommandNotFoundException() {
        this("commands.generic.notFound", new Object[0]);
    }
    
    public CommandNotFoundException(final String llllllllllllllIIIIlIllllIllIIIll, final Object... llllllllllllllIIIIlIllllIllIIIlI) {
        super(llllllllllllllIIIIlIllllIllIIIll, llllllllllllllIIIIlIllllIllIIIlI);
    }
}
