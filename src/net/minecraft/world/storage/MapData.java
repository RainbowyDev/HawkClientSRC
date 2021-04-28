package net.minecraft.world.storage;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.network.play.server.*;
import java.util.*;

public class MapData extends WorldSavedData
{
    public /* synthetic */ byte[] colors;
    public /* synthetic */ byte dimension;
    public /* synthetic */ int zCenter;
    public /* synthetic */ List playersArrayList;
    public /* synthetic */ byte scale;
    public /* synthetic */ Map playersVisibleOnMap;
    private /* synthetic */ Map playersHashMap;
    public /* synthetic */ int xCenter;
    
    public void func_176053_a(final int lllllllllllllllIlIlllIllIIlllIIl, final int lllllllllllllllIlIlllIllIIlllIII) {
        super.markDirty();
        for (final MapInfo lllllllllllllllIlIlllIllIIlllIll : this.playersArrayList) {
            lllllllllllllllIlIlllIllIIlllIll.func_176102_a(lllllllllllllllIlIlllIllIIlllIIl, lllllllllllllllIlIlllIllIIlllIII);
        }
    }
    
    @Override
    public void writeToNBT(final NBTTagCompound lllllllllllllllIlIlllIlllIIlIlll) {
        lllllllllllllllIlIlllIlllIIlIlll.setByte("dimension", this.dimension);
        lllllllllllllllIlIlllIlllIIlIlll.setInteger("xCenter", this.xCenter);
        lllllllllllllllIlIlllIlllIIlIlll.setInteger("zCenter", this.zCenter);
        lllllllllllllllIlIlllIlllIIlIlll.setByte("scale", this.scale);
        lllllllllllllllIlIlllIlllIIlIlll.setShort("width", (short)128);
        lllllllllllllllIlIlllIlllIIlIlll.setShort("height", (short)128);
        lllllllllllllllIlIlllIlllIIlIlll.setByteArray("colors", this.colors);
    }
    
    public MapInfo func_82568_a(final EntityPlayer lllllllllllllllIlIlllIllIIllIIIl) {
        MapInfo lllllllllllllllIlIlllIllIIllIIII = this.playersHashMap.get(lllllllllllllllIlIlllIllIIllIIIl);
        if (lllllllllllllllIlIlllIllIIllIIII == null) {
            lllllllllllllllIlIlllIllIIllIIII = new MapInfo(lllllllllllllllIlIlllIllIIllIIIl);
            this.playersHashMap.put(lllllllllllllllIlIlllIllIIllIIIl, lllllllllllllllIlIlllIllIIllIIII);
            this.playersArrayList.add(lllllllllllllllIlIlllIllIIllIIII);
        }
        return lllllllllllllllIlIlllIllIIllIIII;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllIlIlllIlllIllIIIl) {
        this.dimension = lllllllllllllllIlIlllIlllIllIIIl.getByte("dimension");
        this.xCenter = lllllllllllllllIlIlllIlllIllIIIl.getInteger("xCenter");
        this.zCenter = lllllllllllllllIlIlllIlllIllIIIl.getInteger("zCenter");
        this.scale = lllllllllllllllIlIlllIlllIllIIIl.getByte("scale");
        this.scale = (byte)MathHelper.clamp_int(this.scale, 0, 4);
        final short lllllllllllllllIlIlllIlllIllIIII = lllllllllllllllIlIlllIlllIllIIIl.getShort("width");
        final short lllllllllllllllIlIlllIlllIlIllll = lllllllllllllllIlIlllIlllIllIIIl.getShort("height");
        if (lllllllllllllllIlIlllIlllIllIIII == 128 && lllllllllllllllIlIlllIlllIlIllll == 128) {
            this.colors = lllllllllllllllIlIlllIlllIllIIIl.getByteArray("colors");
        }
        else {
            final byte[] lllllllllllllllIlIlllIlllIlIlllI = lllllllllllllllIlIlllIlllIllIIIl.getByteArray("colors");
            this.colors = new byte[16384];
            final int lllllllllllllllIlIlllIlllIlIllIl = (128 - lllllllllllllllIlIlllIlllIllIIII) / 2;
            final int lllllllllllllllIlIlllIlllIlIllII = (128 - lllllllllllllllIlIlllIlllIlIllll) / 2;
            for (int lllllllllllllllIlIlllIlllIlIlIll = 0; lllllllllllllllIlIlllIlllIlIlIll < lllllllllllllllIlIlllIlllIlIllll; ++lllllllllllllllIlIlllIlllIlIlIll) {
                final int lllllllllllllllIlIlllIlllIlIlIlI = lllllllllllllllIlIlllIlllIlIlIll + lllllllllllllllIlIlllIlllIlIllII;
                if (lllllllllllllllIlIlllIlllIlIlIlI >= 0 || lllllllllllllllIlIlllIlllIlIlIlI < 128) {
                    for (int lllllllllllllllIlIlllIlllIlIlIIl = 0; lllllllllllllllIlIlllIlllIlIlIIl < lllllllllllllllIlIlllIlllIllIIII; ++lllllllllllllllIlIlllIlllIlIlIIl) {
                        final int lllllllllllllllIlIlllIlllIlIlIII = lllllllllllllllIlIlllIlllIlIlIIl + lllllllllllllllIlIlllIlllIlIllIl;
                        if (lllllllllllllllIlIlllIlllIlIlIII >= 0 || lllllllllllllllIlIlllIlllIlIlIII < 128) {
                            this.colors[lllllllllllllllIlIlllIlllIlIlIII + lllllllllllllllIlIlllIlllIlIlIlI * 128] = lllllllllllllllIlIlllIlllIlIlllI[lllllllllllllllIlIlllIlllIlIlIIl + lllllllllllllllIlIlllIlllIlIlIll * lllllllllllllllIlIlllIlllIllIIII];
                        }
                    }
                }
            }
        }
    }
    
    public void updateVisiblePlayers(final EntityPlayer lllllllllllllllIlIlllIlllIIIIlII, final ItemStack lllllllllllllllIlIlllIlllIIIIIll) {
        if (!this.playersHashMap.containsKey(lllllllllllllllIlIlllIlllIIIIlII)) {
            final MapInfo lllllllllllllllIlIlllIlllIIIllIl = new MapInfo(lllllllllllllllIlIlllIlllIIIIlII);
            this.playersHashMap.put(lllllllllllllllIlIlllIlllIIIIlII, lllllllllllllllIlIlllIlllIIIllIl);
            this.playersArrayList.add(lllllllllllllllIlIlllIlllIIIllIl);
        }
        if (!lllllllllllllllIlIlllIlllIIIIlII.inventory.hasItemStack(lllllllllllllllIlIlllIlllIIIIIll)) {
            this.playersVisibleOnMap.remove(lllllllllllllllIlIlllIlllIIIIlII.getName());
        }
        for (int lllllllllllllllIlIlllIlllIIIllII = 0; lllllllllllllllIlIlllIlllIIIllII < this.playersArrayList.size(); ++lllllllllllllllIlIlllIlllIIIllII) {
            final MapInfo lllllllllllllllIlIlllIlllIIIlIll = this.playersArrayList.get(lllllllllllllllIlIlllIlllIIIllII);
            if (!lllllllllllllllIlIlllIlllIIIlIll.entityplayerObj.isDead && (lllllllllllllllIlIlllIlllIIIlIll.entityplayerObj.inventory.hasItemStack(lllllllllllllllIlIlllIlllIIIIIll) || lllllllllllllllIlIlllIlllIIIIIll.isOnItemFrame())) {
                if (!lllllllllllllllIlIlllIlllIIIIIll.isOnItemFrame() && lllllllllllllllIlIlllIlllIIIlIll.entityplayerObj.dimension == this.dimension) {
                    this.func_82567_a(0, lllllllllllllllIlIlllIlllIIIlIll.entityplayerObj.worldObj, lllllllllllllllIlIlllIlllIIIlIll.entityplayerObj.getName(), lllllllllllllllIlIlllIlllIIIlIll.entityplayerObj.posX, lllllllllllllllIlIlllIlllIIIlIll.entityplayerObj.posZ, lllllllllllllllIlIlllIlllIIIlIll.entityplayerObj.rotationYaw);
                }
            }
            else {
                this.playersHashMap.remove(lllllllllllllllIlIlllIlllIIIlIll.entityplayerObj);
                this.playersArrayList.remove(lllllllllllllllIlIlllIlllIIIlIll);
            }
        }
        if (lllllllllllllllIlIlllIlllIIIIIll.isOnItemFrame()) {
            final EntityItemFrame lllllllllllllllIlIlllIlllIIIlIlI = lllllllllllllllIlIlllIlllIIIIIll.getItemFrame();
            final BlockPos lllllllllllllllIlIlllIlllIIIlIIl = lllllllllllllllIlIlllIlllIIIlIlI.func_174857_n();
            this.func_82567_a(1, lllllllllllllllIlIlllIlllIIIIlII.worldObj, String.valueOf(new StringBuilder("frame-").append(lllllllllllllllIlIlllIlllIIIlIlI.getEntityId())), lllllllllllllllIlIlllIlllIIIlIIl.getX(), lllllllllllllllIlIlllIlllIIIlIIl.getZ(), lllllllllllllllIlIlllIlllIIIlIlI.field_174860_b.getHorizontalIndex() * 90);
        }
        if (lllllllllllllllIlIlllIlllIIIIIll.hasTagCompound() && lllllllllllllllIlIlllIlllIIIIIll.getTagCompound().hasKey("Decorations", 9)) {
            final NBTTagList lllllllllllllllIlIlllIlllIIIlIII = lllllllllllllllIlIlllIlllIIIIIll.getTagCompound().getTagList("Decorations", 10);
            for (int lllllllllllllllIlIlllIlllIIIIlll = 0; lllllllllllllllIlIlllIlllIIIIlll < lllllllllllllllIlIlllIlllIIIlIII.tagCount(); ++lllllllllllllllIlIlllIlllIIIIlll) {
                final NBTTagCompound lllllllllllllllIlIlllIlllIIIIllI = lllllllllllllllIlIlllIlllIIIlIII.getCompoundTagAt(lllllllllllllllIlIlllIlllIIIIlll);
                if (!this.playersVisibleOnMap.containsKey(lllllllllllllllIlIlllIlllIIIIllI.getString("id"))) {
                    this.func_82567_a(lllllllllllllllIlIlllIlllIIIIllI.getByte("type"), lllllllllllllllIlIlllIlllIIIIlII.worldObj, lllllllllllllllIlIlllIlllIIIIllI.getString("id"), lllllllllllllllIlIlllIlllIIIIllI.getDouble("x"), lllllllllllllllIlIlllIlllIIIIllI.getDouble("z"), lllllllllllllllIlIlllIlllIIIIllI.getDouble("rot"));
                }
            }
        }
    }
    
    public Packet func_176052_a(final ItemStack lllllllllllllllIlIlllIllIlIIllII, final World lllllllllllllllIlIlllIllIlIIlIll, final EntityPlayer lllllllllllllllIlIlllIllIlIIIllI) {
        final MapInfo lllllllllllllllIlIlllIllIlIIlIIl = this.playersHashMap.get(lllllllllllllllIlIlllIllIlIIIllI);
        return (lllllllllllllllIlIlllIllIlIIlIIl == null) ? null : lllllllllllllllIlIlllIllIlIIlIIl.func_176101_a(lllllllllllllllIlIlllIllIlIIllII);
    }
    
    static {
        __OBFID = "CL_00000577";
    }
    
    public void func_176054_a(final double lllllllllllllllIlIlllIllllIIlIlI, final double lllllllllllllllIlIlllIllllIIlIIl, final int lllllllllllllllIlIlllIllllIIlIII) {
        final int lllllllllllllllIlIlllIllllIIIlll = 128 * (1 << lllllllllllllllIlIlllIllllIIlIII);
        final int lllllllllllllllIlIlllIllllIIIllI = MathHelper.floor_double((lllllllllllllllIlIlllIllllIIlIlI + 64.0) / lllllllllllllllIlIlllIllllIIIlll);
        final int lllllllllllllllIlIlllIllllIIIlIl = MathHelper.floor_double((lllllllllllllllIlIlllIllllIIlIIl + 64.0) / lllllllllllllllIlIlllIllllIIIlll);
        this.xCenter = lllllllllllllllIlIlllIllllIIIllI * lllllllllllllllIlIlllIllllIIIlll + lllllllllllllllIlIlllIllllIIIlll / 2 - 64;
        this.zCenter = lllllllllllllllIlIlllIllllIIIlIl * lllllllllllllllIlIlllIllllIIIlll + lllllllllllllllIlIlllIllllIIIlll / 2 - 64;
    }
    
    private void func_82567_a(int lllllllllllllllIlIlllIllIlIlllll, final World lllllllllllllllIlIlllIllIlIllllI, final String lllllllllllllllIlIlllIllIllIllIl, final double lllllllllllllllIlIlllIllIlIlllII, final double lllllllllllllllIlIlllIllIllIlIll, double lllllllllllllllIlIlllIllIlIllIlI) {
        final int lllllllllllllllIlIlllIllIllIlIIl = 1 << this.scale;
        final float lllllllllllllllIlIlllIllIllIlIII = (float)(lllllllllllllllIlIlllIllIlIlllII - this.xCenter) / lllllllllllllllIlIlllIllIllIlIIl;
        final float lllllllllllllllIlIlllIllIllIIlll = (float)(lllllllllllllllIlIlllIllIllIlIll - this.zCenter) / lllllllllllllllIlIlllIllIllIlIIl;
        byte lllllllllllllllIlIlllIllIllIIllI = (byte)(lllllllllllllllIlIlllIllIllIlIII * 2.0f + 0.5);
        byte lllllllllllllllIlIlllIllIllIIlIl = (byte)(lllllllllllllllIlIlllIllIllIIlll * 2.0f + 0.5);
        final byte lllllllllllllllIlIlllIllIllIIlII = 63;
        byte lllllllllllllllIlIlllIllIllIIIlI = 0;
        if (lllllllllllllllIlIlllIllIllIlIII >= -lllllllllllllllIlIlllIllIllIIlII && lllllllllllllllIlIlllIllIllIIlll >= -lllllllllllllllIlIlllIllIllIIlII && lllllllllllllllIlIlllIllIllIlIII <= lllllllllllllllIlIlllIllIllIIlII && lllllllllllllllIlIlllIllIllIIlll <= lllllllllllllllIlIlllIllIllIIlII) {
            lllllllllllllllIlIlllIllIlIllIlI += ((lllllllllllllllIlIlllIllIlIllIlI < 0.0) ? -8.0 : 8.0);
            byte lllllllllllllllIlIlllIllIllIIIll = (byte)(lllllllllllllllIlIlllIllIlIllIlI * 16.0 / 360.0);
            if (this.dimension < 0) {
                final int lllllllllllllllIlIlllIllIllIIIIl = (int)(lllllllllllllllIlIlllIllIlIllllI.getWorldInfo().getWorldTime() / 10L);
                lllllllllllllllIlIlllIllIllIIIll = (byte)(lllllllllllllllIlIlllIllIllIIIIl * lllllllllllllllIlIlllIllIllIIIIl * 34187121 + lllllllllllllllIlIlllIllIllIIIIl * 121 >> 15 & 0xF);
            }
        }
        else {
            if (Math.abs(lllllllllllllllIlIlllIllIllIlIII) >= 320.0f || Math.abs(lllllllllllllllIlIlllIllIllIIlll) >= 320.0f) {
                this.playersVisibleOnMap.remove(lllllllllllllllIlIlllIllIllIllIl);
                return;
            }
            lllllllllllllllIlIlllIllIlIlllll = 6;
            lllllllllllllllIlIlllIllIllIIIlI = 0;
            if (lllllllllllllllIlIlllIllIllIlIII <= -lllllllllllllllIlIlllIllIllIIlII) {
                lllllllllllllllIlIlllIllIllIIllI = (byte)(lllllllllllllllIlIlllIllIllIIlII * 2 + 2.5);
            }
            if (lllllllllllllllIlIlllIllIllIIlll <= -lllllllllllllllIlIlllIllIllIIlII) {
                lllllllllllllllIlIlllIllIllIIlIl = (byte)(lllllllllllllllIlIlllIllIllIIlII * 2 + 2.5);
            }
            if (lllllllllllllllIlIlllIllIllIlIII >= lllllllllllllllIlIlllIllIllIIlII) {
                lllllllllllllllIlIlllIllIllIIllI = (byte)(lllllllllllllllIlIlllIllIllIIlII * 2 + 1);
            }
            if (lllllllllllllllIlIlllIllIllIIlll >= lllllllllllllllIlIlllIllIllIIlII) {
                lllllllllllllllIlIlllIllIllIIlIl = (byte)(lllllllllllllllIlIlllIllIllIIlII * 2 + 1);
            }
        }
        this.playersVisibleOnMap.put(lllllllllllllllIlIlllIllIllIllIl, new Vec4b((byte)lllllllllllllllIlIlllIllIlIlllll, lllllllllllllllIlIlllIllIllIIllI, lllllllllllllllIlIlllIllIllIIlIl, lllllllllllllllIlIlllIllIllIIIlI));
    }
    
    public MapData(final String lllllllllllllllIlIlllIllllIlIlIl) {
        super(lllllllllllllllIlIlllIllllIlIlIl);
        this.colors = new byte[16384];
        this.playersArrayList = Lists.newArrayList();
        this.playersHashMap = Maps.newHashMap();
        this.playersVisibleOnMap = Maps.newLinkedHashMap();
    }
    
    public class MapInfo
    {
        private /* synthetic */ int field_176108_h;
        public final /* synthetic */ EntityPlayer entityplayerObj;
        private /* synthetic */ int field_176109_i;
        private /* synthetic */ int field_176103_f;
        private /* synthetic */ int field_176106_e;
        private /* synthetic */ int field_176104_g;
        private /* synthetic */ boolean field_176105_d;
        
        public void func_176102_a(final int lllllllllllllllllllllIIIlllllIII, final int lllllllllllllllllllllIIIllllIlll) {
            if (this.field_176105_d) {
                this.field_176106_e = Math.min(this.field_176106_e, lllllllllllllllllllllIIIlllllIII);
                this.field_176103_f = Math.min(this.field_176103_f, lllllllllllllllllllllIIIllllIlll);
                this.field_176104_g = Math.max(this.field_176104_g, lllllllllllllllllllllIIIlllllIII);
                this.field_176108_h = Math.max(this.field_176108_h, lllllllllllllllllllllIIIllllIlll);
            }
            else {
                this.field_176105_d = true;
                this.field_176106_e = lllllllllllllllllllllIIIlllllIII;
                this.field_176103_f = lllllllllllllllllllllIIIllllIlll;
                this.field_176104_g = lllllllllllllllllllllIIIlllllIII;
                this.field_176108_h = lllllllllllllllllllllIIIllllIlll;
            }
        }
        
        public Packet func_176101_a(final ItemStack lllllllllllllllllllllIIIllllllIl) {
            if (this.field_176105_d) {
                this.field_176105_d = false;
                return new S34PacketMaps(lllllllllllllllllllllIIIllllllIl.getMetadata(), MapData.this.scale, MapData.this.playersVisibleOnMap.values(), MapData.this.colors, this.field_176106_e, this.field_176103_f, this.field_176104_g + 1 - this.field_176106_e, this.field_176108_h + 1 - this.field_176103_f);
            }
            return (this.field_176109_i++ % 5 == 0) ? new S34PacketMaps(lllllllllllllllllllllIIIllllllIl.getMetadata(), MapData.this.scale, MapData.this.playersVisibleOnMap.values(), MapData.this.colors, 0, 0, 0, 0) : null;
        }
        
        static {
            __OBFID = "CL_00000578";
        }
        
        public MapInfo(final EntityPlayer lllllllllllllllllllllIIlIIIIIIll) {
            this.field_176105_d = true;
            this.field_176106_e = 0;
            this.field_176103_f = 0;
            this.field_176104_g = 127;
            this.field_176108_h = 127;
            this.entityplayerObj = lllllllllllllllllllllIIlIIIIIIll;
        }
    }
}
