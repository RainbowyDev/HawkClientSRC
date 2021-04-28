package net.minecraft.entity.player;

import net.minecraft.nbt.*;

public class PlayerCapabilities
{
    public /* synthetic */ boolean isCreativeMode;
    public /* synthetic */ boolean allowFlying;
    private /* synthetic */ float flySpeed;
    public /* synthetic */ boolean isFlying;
    public /* synthetic */ boolean allowEdit;
    private /* synthetic */ float walkSpeed;
    public /* synthetic */ boolean disableDamage;
    
    public float getWalkSpeed() {
        return this.walkSpeed;
    }
    
    public PlayerCapabilities() {
        this.allowEdit = true;
        this.flySpeed = 0.05f;
        this.walkSpeed = 0.1f;
    }
    
    public void readCapabilitiesFromNBT(final NBTTagCompound llllllllllllllllIlIIIIIlIIlIIllI) {
        if (llllllllllllllllIlIIIIIlIIlIIllI.hasKey("abilities", 10)) {
            final NBTTagCompound llllllllllllllllIlIIIIIlIIlIlIII = llllllllllllllllIlIIIIIlIIlIIllI.getCompoundTag("abilities");
            this.disableDamage = llllllllllllllllIlIIIIIlIIlIlIII.getBoolean("invulnerable");
            this.isFlying = llllllllllllllllIlIIIIIlIIlIlIII.getBoolean("flying");
            this.allowFlying = llllllllllllllllIlIIIIIlIIlIlIII.getBoolean("mayfly");
            this.isCreativeMode = llllllllllllllllIlIIIIIlIIlIlIII.getBoolean("instabuild");
            if (llllllllllllllllIlIIIIIlIIlIlIII.hasKey("flySpeed", 99)) {
                this.flySpeed = llllllllllllllllIlIIIIIlIIlIlIII.getFloat("flySpeed");
                this.walkSpeed = llllllllllllllllIlIIIIIlIIlIlIII.getFloat("walkSpeed");
            }
            if (llllllllllllllllIlIIIIIlIIlIlIII.hasKey("mayBuild", 1)) {
                this.allowEdit = llllllllllllllllIlIIIIIlIIlIlIII.getBoolean("mayBuild");
            }
        }
    }
    
    public void writeCapabilitiesToNBT(final NBTTagCompound llllllllllllllllIlIIIIIlIIllIIlI) {
        final NBTTagCompound llllllllllllllllIlIIIIIlIIllIIIl = new NBTTagCompound();
        llllllllllllllllIlIIIIIlIIllIIIl.setBoolean("invulnerable", this.disableDamage);
        llllllllllllllllIlIIIIIlIIllIIIl.setBoolean("flying", this.isFlying);
        llllllllllllllllIlIIIIIlIIllIIIl.setBoolean("mayfly", this.allowFlying);
        llllllllllllllllIlIIIIIlIIllIIIl.setBoolean("instabuild", this.isCreativeMode);
        llllllllllllllllIlIIIIIlIIllIIIl.setBoolean("mayBuild", this.allowEdit);
        llllllllllllllllIlIIIIIlIIllIIIl.setFloat("flySpeed", this.flySpeed);
        llllllllllllllllIlIIIIIlIIllIIIl.setFloat("walkSpeed", this.walkSpeed);
        llllllllllllllllIlIIIIIlIIllIIlI.setTag("abilities", llllllllllllllllIlIIIIIlIIllIIIl);
    }
    
    public float getFlySpeed() {
        return this.flySpeed;
    }
    
    static {
        __OBFID = "CL_00001708";
    }
    
    public void setPlayerWalkSpeed(final float llllllllllllllllIlIIIIIlIIIlIlIl) {
        this.walkSpeed = llllllllllllllllIlIIIIIlIIIlIlIl;
    }
    
    public void setFlySpeed(final float llllllllllllllllIlIIIIIlIIIlllII) {
        this.flySpeed = llllllllllllllllIlIIIIIlIIIlllII;
    }
}
