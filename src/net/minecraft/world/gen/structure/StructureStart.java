package net.minecraft.world.gen.structure;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;

public abstract class StructureStart
{
    protected /* synthetic */ StructureBoundingBox boundingBox;
    protected /* synthetic */ LinkedList components;
    private /* synthetic */ int field_143024_c;
    private /* synthetic */ int field_143023_d;
    
    protected void markAvailableHeight(final World llllllllllllllIIIllllIllllIIIIIl, final Random llllllllllllllIIIllllIllllIIIIII, final int llllllllllllllIIIllllIlllIllIIlI) {
        final int llllllllllllllIIIllllIlllIlllllI = 63 - llllllllllllllIIIllllIlllIllIIlI;
        int llllllllllllllIIIllllIlllIllllIl = this.boundingBox.getYSize() + 1;
        if (llllllllllllllIIIllllIlllIllllIl < llllllllllllllIIIllllIlllIlllllI) {
            llllllllllllllIIIllllIlllIllllIl += llllllllllllllIIIllllIllllIIIIII.nextInt(llllllllllllllIIIllllIlllIlllllI - llllllllllllllIIIllllIlllIllllIl);
        }
        final int llllllllllllllIIIllllIlllIlllIll = llllllllllllllIIIllllIlllIllllIl - this.boundingBox.maxY;
        this.boundingBox.offset(0, llllllllllllllIIIllllIlllIlllIll, 0);
        for (final StructureComponent llllllllllllllIIIllllIlllIlllIII : this.components) {
            llllllllllllllIIIllllIlllIlllIII.getBoundingBox().offset(0, llllllllllllllIIIllllIlllIlllIll, 0);
        }
    }
    
    public LinkedList getComponents() {
        return this.components;
    }
    
    public int func_143019_e() {
        return this.field_143024_c;
    }
    
    public void func_143022_a(final NBTTagCompound llllllllllllllIIIllllIlllllIIlIl) {
    }
    
    protected void setRandomHeight(final World llllllllllllllIIIllllIlllIIIIIlI, final Random llllllllllllllIIIllllIllIllIlIlI, final int llllllllllllllIIIllllIllIllllllI, final int llllllllllllllIIIllllIllIllIIllI) {
        final int llllllllllllllIIIllllIllIllllIlI = llllllllllllllIIIllllIllIllIIllI - llllllllllllllIIIllllIllIllllllI + 1 - this.boundingBox.getYSize();
        final boolean llllllllllllllIIIllllIllIllllIII = true;
        int llllllllllllllIIIllllIllIlllIlII = 0;
        if (llllllllllllllIIIllllIllIllllIlI > 1) {
            final int llllllllllllllIIIllllIllIlllIllI = llllllllllllllIIIllllIllIllllllI + llllllllllllllIIIllllIllIllIlIlI.nextInt(llllllllllllllIIIllllIllIllllIlI);
        }
        else {
            llllllllllllllIIIllllIllIlllIlII = llllllllllllllIIIllllIllIllllllI;
        }
        final int llllllllllllllIIIllllIllIlllIIlI = llllllllllllllIIIllllIllIlllIlII - this.boundingBox.minY;
        this.boundingBox.offset(0, llllllllllllllIIIllllIllIlllIIlI, 0);
        for (final StructureComponent llllllllllllllIIIllllIllIllIlllI : this.components) {
            llllllllllllllIIIllllIllIllIlllI.getBoundingBox().offset(0, llllllllllllllIIIllllIllIlllIIlI, 0);
        }
    }
    
    public StructureBoundingBox getBoundingBox() {
        return this.boundingBox;
    }
    
    protected void updateBoundingBox() {
        this.boundingBox = StructureBoundingBox.getNewBoundingBox();
        for (final StructureComponent llllllllllllllIIIlllllIIIIIIllII : this.components) {
            this.boundingBox.expandTo(llllllllllllllIIIlllllIIIIIIllII.getBoundingBox());
        }
    }
    
    static {
        __OBFID = "CL_00000513";
    }
    
    public StructureStart() {
        this.components = new LinkedList();
    }
    
    public void generateStructure(final World llllllllllllllIIIlllllIIIIIlllII, final Random llllllllllllllIIIlllllIIIIIllIll, final StructureBoundingBox llllllllllllllIIIlllllIIIIIlIlII) {
        final Iterator llllllllllllllIIIlllllIIIIIllIIl = this.components.iterator();
        while (llllllllllllllIIIlllllIIIIIllIIl.hasNext()) {
            final StructureComponent llllllllllllllIIIlllllIIIIIllIII = llllllllllllllIIIlllllIIIIIllIIl.next();
            if (llllllllllllllIIIlllllIIIIIllIII.getBoundingBox().intersectsWith(llllllllllllllIIIlllllIIIIIlIlII) && !llllllllllllllIIIlllllIIIIIllIII.addComponentParts(llllllllllllllIIIlllllIIIIIlllII, llllllllllllllIIIlllllIIIIIllIll, llllllllllllllIIIlllllIIIIIlIlII)) {
                llllllllllllllIIIlllllIIIIIllIIl.remove();
            }
        }
    }
    
    public boolean func_175788_a(final ChunkCoordIntPair llllllllllllllIIIllllIllIlIllIlI) {
        return true;
    }
    
    public int func_143018_f() {
        return this.field_143023_d;
    }
    
    public NBTTagCompound func_143021_a(final int llllllllllllllIIIllllIllllllIlII, final int llllllllllllllIIIllllIllllllllII) {
        final NBTTagCompound llllllllllllllIIIllllIlllllllIll = new NBTTagCompound();
        llllllllllllllIIIllllIlllllllIll.setString("id", MapGenStructureIO.func_143033_a(this));
        llllllllllllllIIIllllIlllllllIll.setInteger("ChunkX", llllllllllllllIIIllllIllllllIlII);
        llllllllllllllIIIllllIlllllllIll.setInteger("ChunkZ", llllllllllllllIIIllllIllllllllII);
        llllllllllllllIIIllllIlllllllIll.setTag("BB", this.boundingBox.func_151535_h());
        final NBTTagList llllllllllllllIIIllllIlllllllIlI = new NBTTagList();
        for (final StructureComponent llllllllllllllIIIllllIllllllIlll : this.components) {
            llllllllllllllIIIllllIlllllllIlI.appendTag(llllllllllllllIIIllllIllllllIlll.func_143010_b());
        }
        llllllllllllllIIIllllIlllllllIll.setTag("Children", llllllllllllllIIIllllIlllllllIlI);
        this.func_143022_a(llllllllllllllIIIllllIlllllllIll);
        return llllllllllllllIIIllllIlllllllIll;
    }
    
    public StructureStart(final int llllllllllllllIIIlllllIIIIlIlIll, final int llllllllllllllIIIlllllIIIIlIlIlI) {
        this.components = new LinkedList();
        this.field_143024_c = llllllllllllllIIIlllllIIIIlIlIll;
        this.field_143023_d = llllllllllllllIIIlllllIIIIlIlIlI;
    }
    
    public boolean isSizeableStructure() {
        return true;
    }
    
    public void func_143017_b(final NBTTagCompound llllllllllllllIIIllllIllllIIlIll) {
    }
    
    public void func_143020_a(final World llllllllllllllIIIllllIllllIlIIII, final NBTTagCompound llllllllllllllIIIllllIllllIIllll) {
        this.field_143024_c = llllllllllllllIIIllllIllllIIllll.getInteger("ChunkX");
        this.field_143023_d = llllllllllllllIIIllllIllllIIllll.getInteger("ChunkZ");
        if (llllllllllllllIIIllllIllllIIllll.hasKey("BB")) {
            this.boundingBox = new StructureBoundingBox(llllllllllllllIIIllllIllllIIllll.getIntArray("BB"));
        }
        final NBTTagList llllllllllllllIIIllllIllllIlIIll = llllllllllllllIIIllllIllllIIllll.getTagList("Children", 10);
        for (int llllllllllllllIIIllllIllllIlIIlI = 0; llllllllllllllIIIllllIllllIlIIlI < llllllllllllllIIIllllIllllIlIIll.tagCount(); ++llllllllllllllIIIllllIllllIlIIlI) {
            this.components.add(MapGenStructureIO.func_143032_b(llllllllllllllIIIllllIllllIlIIll.getCompoundTagAt(llllllllllllllIIIllllIllllIlIIlI), llllllllllllllIIIllllIllllIlIIII));
        }
        this.func_143017_b(llllllllllllllIIIllllIllllIIllll);
    }
    
    public void func_175787_b(final ChunkCoordIntPair llllllllllllllIIIllllIllIlIllIII) {
    }
}
