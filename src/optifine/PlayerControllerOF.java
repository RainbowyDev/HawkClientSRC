package optifine;

import net.minecraft.client.entity.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

public class PlayerControllerOF extends PlayerControllerMP
{
    private /* synthetic */ boolean acting;
    
    @Override
    public boolean func_180511_b(final BlockPos llllllllllllllIlIIIIIIIIIIIlIlIl, final EnumFacing llllllllllllllIlIIIIIIIIIIIlIIII) {
        this.acting = true;
        final boolean llllllllllllllIlIIIIIIIIIIIlIIll = super.func_180511_b(llllllllllllllIlIIIIIIIIIIIlIlIl, llllllllllllllIlIIIIIIIIIIIlIIII);
        this.acting = false;
        return llllllllllllllIlIIIIIIIIIIIlIIll;
    }
    
    @Override
    public boolean func_178890_a(final EntityPlayerSP llllllllllllllIIlllllllllllIlIlI, final WorldClient llllllllllllllIIlllllllllllIIIIl, final ItemStack llllllllllllllIIlllllllllllIIIII, final BlockPos llllllllllllllIIllllllllllIlllll, final EnumFacing llllllllllllllIIllllllllllIllllI, final Vec3 llllllllllllllIIlllllllllllIIlIl) {
        this.acting = true;
        final boolean llllllllllllllIIlllllllllllIIlII = super.func_178890_a(llllllllllllllIIlllllllllllIlIlI, llllllllllllllIIlllllllllllIIIIl, llllllllllllllIIlllllllllllIIIII, llllllllllllllIIllllllllllIlllll, llllllllllllllIIllllllllllIllllI, llllllllllllllIIlllllllllllIIlIl);
        this.acting = false;
        return llllllllllllllIIlllllllllllIIlII;
    }
    
    public PlayerControllerOF(final Minecraft llllllllllllllIlIIIIIIIIIIIlllII, final NetHandlerPlayClient llllllllllllllIlIIIIIIIIIIIllIll) {
        super(llllllllllllllIlIIIIIIIIIIIlllII, llllllllllllllIlIIIIIIIIIIIllIll);
        this.acting = false;
    }
    
    public boolean isActing() {
        return this.acting;
    }
    
    @Override
    public boolean sendUseItem(final EntityPlayer llllllllllllllIIllllllllllllllII, final World llllllllllllllIIlllllllllllllIll, final ItemStack llllllllllllllIIllllllllllllIlIl) {
        this.acting = true;
        final boolean llllllllllllllIIlllllllllllllIIl = super.sendUseItem(llllllllllllllIIllllllllllllllII, llllllllllllllIIlllllllllllllIll, llllllllllllllIIllllllllllllIlIl);
        this.acting = false;
        return llllllllllllllIIlllllllllllllIIl;
    }
    
    @Override
    public boolean func_180512_c(final BlockPos llllllllllllllIlIIIIIIIIIIIIlIIl, final EnumFacing llllllllllllllIlIIIIIIIIIIIIlIII) {
        this.acting = true;
        final boolean llllllllllllllIlIIIIIIIIIIIIIlll = super.func_180512_c(llllllllllllllIlIIIIIIIIIIIIlIIl, llllllllllllllIlIIIIIIIIIIIIlIII);
        this.acting = false;
        return llllllllllllllIlIIIIIIIIIIIIIlll;
    }
}
