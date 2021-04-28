package net.minecraft.command;

public class PlayerNotFoundException extends CommandException
{
    public PlayerNotFoundException(final String lllllllllllllllllIlIllllIlIllIII, final Object... lllllllllllllllllIlIllllIlIlIlII) {
        super(lllllllllllllllllIlIllllIlIllIII, lllllllllllllllllIlIllllIlIlIlII);
    }
    
    static {
        __OBFID = "CL_00001190";
    }
    
    public PlayerNotFoundException() {
        this("commands.generic.player.notFound", new Object[0]);
    }
}
