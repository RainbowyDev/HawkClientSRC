package optifine;

import net.minecraft.block.state.*;

public class MatchBlock
{
    private /* synthetic */ int blockId;
    private /* synthetic */ int[] metadatas;
    
    public int getBlockId() {
        return this.blockId;
    }
    
    public int[] getMetadatas() {
        return this.metadatas;
    }
    
    public MatchBlock(final int llllllllllllllIlIlIllllIIllllIll, final int[] llllllllllllllIlIlIllllIIlllIlll) {
        this.blockId = -1;
        this.metadatas = null;
        this.blockId = llllllllllllllIlIlIllllIIllllIll;
        this.metadatas = llllllllllllllIlIlIllllIIlllIlll;
    }
    
    public void addMetadata(final int llllllllllllllIlIlIllllIIlIlIlll) {
        if (this.metadatas != null && llllllllllllllIlIlIllllIIlIlIlll >= 0 && llllllllllllllIlIlIllllIIlIlIlll <= 15) {
            for (int llllllllllllllIlIlIllllIIlIllIIl = 0; llllllllllllllIlIlIllllIIlIllIIl < this.metadatas.length; ++llllllllllllllIlIlIllllIIlIllIIl) {
                if (this.metadatas[llllllllllllllIlIlIllllIIlIllIIl] == llllllllllllllIlIlIllllIIlIlIlll) {
                    return;
                }
            }
            this.metadatas = Config.addIntToArray(this.metadatas, llllllllllllllIlIlIllllIIlIlIlll);
        }
    }
    
    public MatchBlock(final int llllllllllllllIlIlIllllIlIIIIlII, final int llllllllllllllIlIlIllllIlIIIIIll) {
        this.blockId = -1;
        this.metadatas = null;
        this.blockId = llllllllllllllIlIlIllllIlIIIIlII;
        if (llllllllllllllIlIlIllllIlIIIIIll >= 0 && llllllllllllllIlIlIllllIlIIIIIll <= 15) {
            this.metadatas = new int[] { llllllllllllllIlIlIllllIlIIIIIll };
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.blockId).append(":").append(Config.arrayToString(this.metadatas)));
    }
    
    public boolean matches(final int llllllllllllllIlIlIllllIIllIIllI, final int llllllllllllllIlIlIllllIIllIIlIl) {
        return llllllllllllllIlIlIllllIIllIIllI == this.blockId && Matches.metadata(llllllllllllllIlIlIllllIIllIIlIl, this.metadatas);
    }
    
    public MatchBlock(final int llllllllllllllIlIlIllllIlIIIlIll) {
        this.blockId = -1;
        this.metadatas = null;
        this.blockId = llllllllllllllIlIlIllllIlIIIlIll;
    }
    
    public boolean matches(final BlockStateBase llllllllllllllIlIlIllllIIllIlIll) {
        return llllllllllllllIlIlIllllIIllIlIll.getBlockId() == this.blockId && Matches.metadata(llllllllllllllIlIlIllllIIllIlIll.getMetadata(), this.metadatas);
    }
}
