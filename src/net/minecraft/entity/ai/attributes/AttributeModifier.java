package net.minecraft.entity.ai.attributes;

import io.netty.util.internal.*;
import net.minecraft.util.*;
import java.util.*;
import org.apache.commons.lang3.*;

public class AttributeModifier
{
    private final /* synthetic */ double amount;
    private final /* synthetic */ int operation;
    private final /* synthetic */ UUID id;
    private /* synthetic */ boolean isSaved;
    private final /* synthetic */ String name;
    
    public int getOperation() {
        return this.operation;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("AttributeModifier{amount=").append(this.amount).append(", operation=").append(this.operation).append(", name='").append(this.name).append('\'').append(", id=").append(this.id).append(", serialize=").append(this.isSaved).append('}'));
    }
    
    @Override
    public boolean equals(final Object lIlIIlIIIllllI) {
        if (this == lIlIIlIIIllllI) {
            return true;
        }
        if (lIlIIlIIIllllI != null && this.getClass() == lIlIIlIIIllllI.getClass()) {
            final AttributeModifier lIlIIlIIIlllIl = (AttributeModifier)lIlIIlIIIllllI;
            if (this.id != null) {
                if (!this.id.equals(lIlIIlIIIlllIl.id)) {
                    return false;
                }
            }
            else if (lIlIIlIIIlllIl.id != null) {
                return false;
            }
            return true;
        }
        return false;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public String getName() {
        return this.name;
    }
    
    static {
        __OBFID = "CL_00001564";
    }
    
    public AttributeModifier(final String lIlIIlIlIIlIIl, final double lIlIIlIlIIlIII, final int lIlIIlIlIIIlll) {
        this(MathHelper.func_180182_a((Random)ThreadLocalRandom.current()), lIlIIlIlIIlIIl, lIlIIlIlIIlIII, lIlIIlIlIIIlll);
    }
    
    public boolean isSaved() {
        return this.isSaved;
    }
    
    public AttributeModifier setSaved(final boolean lIlIIlIIlIIlIl) {
        this.isSaved = lIlIIlIIlIIlIl;
        return this;
    }
    
    public UUID getID() {
        return this.id;
    }
    
    public AttributeModifier(final UUID lIlIIlIIlllIll, final String lIlIIlIIlllIlI, final double lIlIIlIIlllIIl, final int lIlIIlIIllllIl) {
        this.isSaved = true;
        this.id = lIlIIlIIlllIll;
        this.name = lIlIIlIIlllIlI;
        this.amount = lIlIIlIIlllIIl;
        this.operation = lIlIIlIIllllIl;
        Validate.notEmpty((CharSequence)lIlIIlIIlllIlI, "Modifier name cannot be empty", new Object[0]);
        Validate.inclusiveBetween(0L, 2L, (long)lIlIIlIIllllIl, "Invalid operation");
    }
    
    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : 0;
    }
}
