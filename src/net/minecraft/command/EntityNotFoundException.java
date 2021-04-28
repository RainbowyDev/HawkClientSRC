package net.minecraft.command;

public class EntityNotFoundException extends CommandException
{
    public EntityNotFoundException() {
        this("commands.generic.entity.notFound", new Object[0]);
    }
    
    static {
        __OBFID = "CL_00002335";
    }
    
    public EntityNotFoundException(final String llllllllllllllIlIlIIIlllIIllllIl, final Object... llllllllllllllIlIlIIIlllIIlllIIl) {
        super(llllllllllllllIlIlIIIlllIIllllIl, llllllllllllllIlIlIIIlllIIlllIIl);
    }
}
