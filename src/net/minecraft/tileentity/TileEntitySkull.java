package net.minecraft.tileentity;

import com.mojang.authlib.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import net.minecraft.server.*;
import com.mojang.authlib.properties.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;
import java.util.*;

public class TileEntitySkull extends TileEntity
{
    private /* synthetic */ int skullRotation;
    private /* synthetic */ int skullType;
    private /* synthetic */ GameProfile playerProfile;
    
    @Override
    public Packet getDescriptionPacket() {
        final NBTTagCompound llIIIlIllIIIllI = new NBTTagCompound();
        this.writeToNBT(llIIIlIllIIIllI);
        return new S35PacketUpdateTileEntity(this.pos, 4, llIIIlIllIIIllI);
    }
    
    public void setSkullRotation(final int llIIIlIlIIIlllI) {
        this.skullRotation = llIIIlIlIIIlllI;
    }
    
    public int getSkullRotation() {
        return this.skullRotation;
    }
    
    public void setPlayerProfile(final GameProfile llIIIlIlIlllIlI) {
        this.skullType = 3;
        this.playerProfile = llIIIlIlIlllIlI;
        this.func_152109_d();
    }
    
    public int getSkullType() {
        return this.skullType;
    }
    
    public TileEntitySkull() {
        this.playerProfile = null;
    }
    
    public void setType(final int llIIIlIllIIIIII) {
        this.skullType = llIIIlIllIIIIII;
        this.playerProfile = null;
    }
    
    public static GameProfile updateGameprofile(final GameProfile llIIIlIlIlIlIlI) {
        if (llIIIlIlIlIlIlI == null || StringUtils.isNullOrEmpty(llIIIlIlIlIlIlI.getName())) {
            return llIIIlIlIlIlIlI;
        }
        if (llIIIlIlIlIlIlI.isComplete() && llIIIlIlIlIlIlI.getProperties().containsKey((Object)"textures")) {
            return llIIIlIlIlIlIlI;
        }
        if (MinecraftServer.getServer() == null) {
            return llIIIlIlIlIlIlI;
        }
        GameProfile llIIIlIlIlIllII = MinecraftServer.getServer().getPlayerProfileCache().getGameProfileForUsername(llIIIlIlIlIlIlI.getName());
        if (llIIIlIlIlIllII == null) {
            return llIIIlIlIlIlIlI;
        }
        final Property llIIIlIlIlIlIll = (Property)Iterables.getFirst((Iterable)llIIIlIlIlIllII.getProperties().get((Object)"textures"), (Object)null);
        if (llIIIlIlIlIlIll == null) {
            llIIIlIlIlIllII = MinecraftServer.getServer().getMinecraftSessionService().fillProfileProperties(llIIIlIlIlIllII, true);
        }
        return llIIIlIlIlIllII;
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound llIIIlIllIlIlll) {
        super.writeToNBT(llIIIlIllIlIlll);
        llIIIlIllIlIlll.setByte("SkullType", (byte)(this.skullType & 0xFF));
        llIIIlIllIlIlll.setByte("Rot", (byte)(this.skullRotation & 0xFF));
        if (this.playerProfile != null) {
            final NBTTagCompound llIIIlIllIllIIl = new NBTTagCompound();
            NBTUtil.writeGameProfile(llIIIlIllIllIIl, this.playerProfile);
            llIIIlIllIlIlll.setTag("Owner", llIIIlIllIllIIl);
        }
    }
    
    public GameProfile getPlayerProfile() {
        return this.playerProfile;
    }
    
    private void func_152109_d() {
        this.playerProfile = updateGameprofile(this.playerProfile);
        this.markDirty();
    }
    
    static {
        __OBFID = "CL_00000364";
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llIIIlIllIlIIIl) {
        super.readFromNBT(llIIIlIllIlIIIl);
        this.skullType = llIIIlIllIlIIIl.getByte("SkullType");
        this.skullRotation = llIIIlIllIlIIIl.getByte("Rot");
        if (this.skullType == 3) {
            if (llIIIlIllIlIIIl.hasKey("Owner", 10)) {
                this.playerProfile = NBTUtil.readGameProfileFromNBT(llIIIlIllIlIIIl.getCompoundTag("Owner"));
            }
            else if (llIIIlIllIlIIIl.hasKey("ExtraType", 8)) {
                final String llIIIlIllIlIIII = llIIIlIllIlIIIl.getString("ExtraType");
                if (!StringUtils.isNullOrEmpty(llIIIlIllIlIIII)) {
                    this.playerProfile = new GameProfile((UUID)null, llIIIlIllIlIIII);
                    this.func_152109_d();
                }
            }
        }
    }
}
