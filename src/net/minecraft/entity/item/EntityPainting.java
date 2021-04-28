package net.minecraft.entity.item;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class EntityPainting extends EntityHanging
{
    public /* synthetic */ EnumArt art;
    
    public EntityPainting(final World llllllllllllllllIllIlIlIlIlIlIIl) {
        super(llllllllllllllllIllIlIlIlIlIlIIl);
    }
    
    @Override
    public void setLocationAndAngles(final double llllllllllllllllIllIlIlIIlIIIIIl, final double llllllllllllllllIllIlIlIIlIIIIII, final double llllllllllllllllIllIlIlIIIllllll, final float llllllllllllllllIllIlIlIIIlllllI, final float llllllllllllllllIllIlIlIIIllllIl) {
        final BlockPos llllllllllllllllIllIlIlIIIllllII = new BlockPos(llllllllllllllllIllIlIlIIlIIIIIl - this.posX, llllllllllllllllIllIlIlIIlIIIIII - this.posY, llllllllllllllllIllIlIlIIIllllll - this.posZ);
        final BlockPos llllllllllllllllIllIlIlIIIlllIll = this.field_174861_a.add(llllllllllllllllIllIlIlIIIllllII);
        this.setPosition(llllllllllllllllIllIlIlIIIlllIll.getX(), llllllllllllllllIllIlIlIIIlllIll.getY(), llllllllllllllllIllIlIlIIIlllIll.getZ());
    }
    
    public EntityPainting(final World llllllllllllllllIllIlIlIlIIIIIll, final BlockPos llllllllllllllllIllIlIlIlIIIIIlI, final EnumFacing llllllllllllllllIllIlIlIIllllIII, final String llllllllllllllllIllIlIlIIlllIlll) {
        this(llllllllllllllllIllIlIlIlIIIIIll, llllllllllllllllIllIlIlIlIIIIIlI, llllllllllllllllIllIlIlIIllllIII);
        for (final EnumArt llllllllllllllllIllIlIlIIlllllII : EnumArt.values()) {
            if (llllllllllllllllIllIlIlIIlllllII.title.equals(llllllllllllllllIllIlIlIIlllIlll)) {
                this.art = llllllllllllllllIllIlIlIIlllllII;
                break;
            }
        }
        this.func_174859_a(llllllllllllllllIllIlIlIIllllIII);
    }
    
    @Override
    public int getHeightPixels() {
        return this.art.sizeY;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIllIlIlIIlIlllIl) {
        final String llllllllllllllllIllIlIlIIllIIIll = llllllllllllllllIllIlIlIIlIlllIl.getString("Motive");
        for (final EnumArt llllllllllllllllIllIlIlIIlIlllll : EnumArt.values()) {
            if (llllllllllllllllIllIlIlIIlIlllll.title.equals(llllllllllllllllIllIlIlIIllIIIll)) {
                this.art = llllllllllllllllIllIlIlIIlIlllll;
            }
        }
        if (this.art == null) {
            this.art = EnumArt.KEBAB;
        }
        super.readEntityFromNBT(llllllllllllllllIllIlIlIIlIlllIl);
    }
    
    @Override
    public void func_180426_a(final double llllllllllllllllIllIlIlIIIlIIIll, final double llllllllllllllllIllIlIlIIIlIllII, final double llllllllllllllllIllIlIlIIIlIlIll, final float llllllllllllllllIllIlIlIIIlIlIlI, final float llllllllllllllllIllIlIlIIIlIlIIl, final int llllllllllllllllIllIlIlIIIlIlIII, final boolean llllllllllllllllIllIlIlIIIlIIlll) {
        final BlockPos llllllllllllllllIllIlIlIIIlIIllI = new BlockPos(llllllllllllllllIllIlIlIIIlIIIll - this.posX, llllllllllllllllIllIlIlIIIlIllII - this.posY, llllllllllllllllIllIlIlIIIlIlIll - this.posZ);
        final BlockPos llllllllllllllllIllIlIlIIIlIIlIl = this.field_174861_a.add(llllllllllllllllIllIlIlIIIlIIllI);
        this.setPosition(llllllllllllllllIllIlIlIIIlIIlIl.getX(), llllllllllllllllIllIlIlIIIlIIlIl.getY(), llllllllllllllllIllIlIlIIIlIIlIl.getZ());
    }
    
    @Override
    public int getWidthPixels() {
        return this.art.sizeX;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIllIlIlIIllIllll) {
        llllllllllllllllIllIlIlIIllIllll.setString("Motive", this.art.title);
        super.writeEntityToNBT(llllllllllllllllIllIlIlIIllIllll);
    }
    
    public EntityPainting(final World llllllllllllllllIllIlIlIlIIlIlIl, final BlockPos llllllllllllllllIllIlIlIlIIlllIl, final EnumFacing llllllllllllllllIllIlIlIlIIlllII) {
        super(llllllllllllllllIllIlIlIlIIlIlIl, llllllllllllllllIllIlIlIlIIlllIl);
        final ArrayList llllllllllllllllIllIlIlIlIIllIll = Lists.newArrayList();
        for (final EnumArt llllllllllllllllIllIlIlIlIIlIlll : EnumArt.values()) {
            this.art = llllllllllllllllIllIlIlIlIIlIlll;
            this.func_174859_a(llllllllllllllllIllIlIlIlIIlllII);
            if (this.onValidSurface()) {
                llllllllllllllllIllIlIlIlIIllIll.add(llllllllllllllllIllIlIlIlIIlIlll);
            }
        }
        if (!llllllllllllllllIllIlIlIlIIllIll.isEmpty()) {
            this.art = llllllllllllllllIllIlIlIlIIllIll.get(this.rand.nextInt(llllllllllllllllIllIlIlIlIIllIll.size()));
        }
        this.func_174859_a(llllllllllllllllIllIlIlIlIIlllII);
    }
    
    static {
        __OBFID = "CL_00001556";
    }
    
    @Override
    public void onBroken(final Entity llllllllllllllllIllIlIlIIlIIlIlI) {
        if (this.worldObj.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
            if (llllllllllllllllIllIlIlIIlIIlIlI instanceof EntityPlayer) {
                final EntityPlayer llllllllllllllllIllIlIlIIlIIllII = (EntityPlayer)llllllllllllllllIllIlIlIIlIIlIlI;
                if (llllllllllllllllIllIlIlIIlIIllII.capabilities.isCreativeMode) {
                    return;
                }
            }
            this.entityDropItem(new ItemStack(Items.painting), 0.0f);
        }
    }
    
    public enum EnumArt
    {
        SEA("SEA", 9, "SEA", 9, "Sea", 32, 16, 64, 32), 
        BOMB("BOMB", 4, "BOMB", 4, "Bomb", 16, 16, 64, 0), 
        PLANT("PLANT", 5, "PLANT", 5, "Plant", 16, 16, 80, 0), 
        AZTEC_2("AZTEC_2", 3, "AZTEC_2", 3, "Aztec2", 16, 16, 48, 0);
        
        public final /* synthetic */ int offsetY;
        
        ALBAN("ALBAN", 2, "ALBAN", 2, "Alban", 16, 16, 32, 0);
        
        public final /* synthetic */ int offsetX;
        
        BURNING_SKULL("BURNING_SKULL", 23, "BURNING_SKULL", 23, "BurningSkull", 64, 64, 128, 192), 
        MATCH("MATCH", 14, "MATCH", 14, "Match", 32, 32, 0, 128), 
        WASTELAND("WASTELAND", 6, "WASTELAND", 6, "Wasteland", 16, 16, 96, 0), 
        DONKEY_KONG("DONKEY_KONG", 25, "DONKEY_KONG", 25, "DonkeyKong", 64, 48, 192, 112), 
        WANDERER("WANDERER", 12, "WANDERER", 12, "Wanderer", 16, 32, 0, 64), 
        BUST("BUST", 15, "BUST", 15, "Bust", 32, 32, 32, 128);
        
        public final /* synthetic */ int sizeY;
        
        POOL("POOL", 7, "POOL", 7, "Pool", 32, 16, 0, 32);
        
        public final /* synthetic */ int sizeX;
        
        POINTER("POINTER", 21, "POINTER", 21, "Pointer", 64, 64, 0, 192), 
        WITHER("WITHER", 19, "WITHER", 19, "Wither", 32, 32, 160, 128), 
        VOID("VOID", 17, "VOID", 17, "Void", 32, 32, 96, 128), 
        SUNSET("SUNSET", 10, "SUNSET", 10, "Sunset", 32, 16, 96, 32);
        
        public final /* synthetic */ String title;
        
        GRAHAM("GRAHAM", 13, "GRAHAM", 13, "Graham", 16, 32, 16, 64), 
        FIGHTERS("FIGHTERS", 20, "FIGHTERS", 20, "Fighters", 64, 32, 0, 96), 
        COURBET("COURBET", 8, "COURBET", 8, "Courbet", 32, 16, 32, 32), 
        AZTEC("AZTEC", 1, "AZTEC", 1, "Aztec", 16, 16, 16, 0), 
        STAGE("STAGE", 16, "STAGE", 16, "Stage", 32, 32, 64, 128), 
        KEBAB("KEBAB", 0, "KEBAB", 0, "Kebab", 16, 16, 0, 0), 
        SKELETON("SKELETON", 24, "SKELETON", 24, "Skeleton", 64, 48, 192, 64), 
        PIGSCENE("PIGSCENE", 22, "PIGSCENE", 22, "Pigscene", 64, 64, 64, 192), 
        CREEBET("CREEBET", 11, "CREEBET", 11, "Creebet", 32, 16, 128, 32), 
        SKULL_AND_ROSES("SKULL_AND_ROSES", 18, "SKULL_AND_ROSES", 18, "SkullAndRoses", 32, 32, 128, 128);
        
        static {
            __OBFID = "CL_00001557";
            field_180001_A = "SkullAndRoses".length();
        }
        
        private EnumArt(final String llllllllllllllIllllllllIlIIlIIIl, final int llllllllllllllIllllllllIlIIlIIII, final String llllllllllllllIllllllllIlIIllIIl, final int llllllllllllllIllllllllIlIIllIII, final String llllllllllllllIllllllllIlIIIllll, final int llllllllllllllIllllllllIlIIIlllI, final int llllllllllllllIllllllllIlIIIllIl, final int llllllllllllllIllllllllIlIIlIlII, final int llllllllllllllIllllllllIlIIlIIll) {
            this.title = llllllllllllllIllllllllIlIIIllll;
            this.sizeX = llllllllllllllIllllllllIlIIIlllI;
            this.sizeY = llllllllllllllIllllllllIlIIIllIl;
            this.offsetX = llllllllllllllIllllllllIlIIlIlII;
            this.offsetY = llllllllllllllIllllllllIlIIlIIll;
        }
    }
}
