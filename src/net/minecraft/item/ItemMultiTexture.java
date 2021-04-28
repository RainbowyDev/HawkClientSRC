package net.minecraft.item;

import net.minecraft.block.*;
import com.google.common.base.*;

public class ItemMultiTexture extends ItemBlock
{
    protected final /* synthetic */ Block theBlock;
    protected final /* synthetic */ Function nameFunction;
    
    public ItemMultiTexture(final Block lIllIlIllIlII, final Block lIllIlIllIlll, final Function lIllIlIllIIlI) {
        super(lIllIlIllIlII);
        this.theBlock = lIllIlIllIlll;
        this.nameFunction = lIllIlIllIIlI;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    public ItemMultiTexture(final Block lIllIlIlIllII, final Block lIllIlIlIIlll, final String[] lIllIlIlIIllI) {
        this(lIllIlIlIllII, lIllIlIlIIlll, (Function)new Function() {
            public String apply(final ItemStack llllllllllllllllIlIllllIlIllIIll) {
                int llllllllllllllllIlIllllIlIllIIlI = llllllllllllllllIlIllllIlIllIIll.getMetadata();
                if (llllllllllllllllIlIllllIlIllIIlI < 0 || llllllllllllllllIlIllllIlIllIIlI >= lIllIlIlIIllI.length) {
                    llllllllllllllllIlIllllIlIllIIlI = 0;
                }
                return lIllIlIlIIllI[llllllllllllllllIlIllllIlIllIIlI];
            }
            
            static {
                __OBFID = "CL_00002161";
            }
            
            public Object apply(final Object llllllllllllllllIlIllllIlIlIlIll) {
                return this.apply((ItemStack)llllllllllllllllIlIllllIlIlIlIll);
            }
        });
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lIllIlIIllllI) {
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append((String)this.nameFunction.apply((Object)lIllIlIIllllI)));
    }
    
    @Override
    public int getMetadata(final int lIllIlIlIIIll) {
        return lIllIlIlIIIll;
    }
    
    static {
        __OBFID = "CL_00000051";
    }
}
