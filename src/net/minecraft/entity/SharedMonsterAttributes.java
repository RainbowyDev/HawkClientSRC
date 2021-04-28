package net.minecraft.entity;

import net.minecraft.nbt.*;
import java.util.*;
import org.apache.logging.log4j.*;
import net.minecraft.entity.ai.attributes.*;

public class SharedMonsterAttributes
{
    private static final /* synthetic */ Logger logger;
    
    private static NBTTagCompound writeAttributeInstanceToNBT(final IAttributeInstance llllllllllllllIIIIIllIllIllllIIl) {
        final NBTTagCompound llllllllllllllIIIIIllIllIllllIII = new NBTTagCompound();
        final IAttribute llllllllllllllIIIIIllIllIlllIlll = llllllllllllllIIIIIllIllIllllIIl.getAttribute();
        llllllllllllllIIIIIllIllIllllIII.setString("Name", llllllllllllllIIIIIllIllIlllIlll.getAttributeUnlocalizedName());
        llllllllllllllIIIIIllIllIllllIII.setDouble("Base", llllllllllllllIIIIIllIllIllllIIl.getBaseValue());
        final Collection llllllllllllllIIIIIllIllIlllIllI = llllllllllllllIIIIIllIllIllllIIl.func_111122_c();
        if (llllllllllllllIIIIIllIllIlllIllI != null && !llllllllllllllIIIIIllIllIlllIllI.isEmpty()) {
            final NBTTagList llllllllllllllIIIIIllIllIlllIlIl = new NBTTagList();
            for (final AttributeModifier llllllllllllllIIIIIllIllIlllIIll : llllllllllllllIIIIIllIllIlllIllI) {
                if (llllllllllllllIIIIIllIllIlllIIll.isSaved()) {
                    llllllllllllllIIIIIllIllIlllIlIl.appendTag(writeAttributeModifierToNBT(llllllllllllllIIIIIllIllIlllIIll));
                }
            }
            llllllllllllllIIIIIllIllIllllIII.setTag("Modifiers", llllllllllllllIIIIIllIllIlllIlIl);
        }
        return llllllllllllllIIIIIllIllIllllIII;
    }
    
    private static void applyModifiersToAttributeInstance(final IAttributeInstance llllllllllllllIIIIIllIllIlIlIIII, final NBTTagCompound llllllllllllllIIIIIllIllIlIIlIIl) {
        llllllllllllllIIIIIllIllIlIlIIII.setBaseValue(llllllllllllllIIIIIllIllIlIIlIIl.getDouble("Base"));
        if (llllllllllllllIIIIIllIllIlIIlIIl.hasKey("Modifiers", 9)) {
            final NBTTagList llllllllllllllIIIIIllIllIlIIlllI = llllllllllllllIIIIIllIllIlIIlIIl.getTagList("Modifiers", 10);
            for (int llllllllllllllIIIIIllIllIlIIllIl = 0; llllllllllllllIIIIIllIllIlIIllIl < llllllllllllllIIIIIllIllIlIIlllI.tagCount(); ++llllllllllllllIIIIIllIllIlIIllIl) {
                final AttributeModifier llllllllllllllIIIIIllIllIlIIllII = readAttributeModifierFromNBT(llllllllllllllIIIIIllIllIlIIlllI.getCompoundTagAt(llllllllllllllIIIIIllIllIlIIllIl));
                if (llllllllllllllIIIIIllIllIlIIllII != null) {
                    final AttributeModifier llllllllllllllIIIIIllIllIlIIlIll = llllllllllllllIIIIIllIllIlIlIIII.getModifier(llllllllllllllIIIIIllIllIlIIllII.getID());
                    if (llllllllllllllIIIIIllIllIlIIlIll != null) {
                        llllllllllllllIIIIIllIllIlIlIIII.removeModifier(llllllllllllllIIIIIllIllIlIIlIll);
                    }
                    llllllllllllllIIIIIllIllIlIlIIII.applyModifier(llllllllllllllIIIIIllIllIlIIllII);
                }
            }
        }
    }
    
    private static NBTTagCompound writeAttributeModifierToNBT(final AttributeModifier llllllllllllllIIIIIllIllIllIlIIl) {
        final NBTTagCompound llllllllllllllIIIIIllIllIllIlIII = new NBTTagCompound();
        llllllllllllllIIIIIllIllIllIlIII.setString("Name", llllllllllllllIIIIIllIllIllIlIIl.getName());
        llllllllllllllIIIIIllIllIllIlIII.setDouble("Amount", llllllllllllllIIIIIllIllIllIlIIl.getAmount());
        llllllllllllllIIIIIllIllIllIlIII.setInteger("Operation", llllllllllllllIIIIIllIllIllIlIIl.getOperation());
        llllllllllllllIIIIIllIllIllIlIII.setLong("UUIDMost", llllllllllllllIIIIIllIllIllIlIIl.getID().getMostSignificantBits());
        llllllllllllllIIIIIllIllIllIlIII.setLong("UUIDLeast", llllllllllllllIIIIIllIllIllIlIIl.getID().getLeastSignificantBits());
        return llllllllllllllIIIIIllIllIllIlIII;
    }
    
    public static void func_151475_a(final BaseAttributeMap llllllllllllllIIIIIllIllIllIIIII, final NBTTagList llllllllllllllIIIIIllIllIlIlllll) {
        for (int llllllllllllllIIIIIllIllIlIllllI = 0; llllllllllllllIIIIIllIllIlIllllI < llllllllllllllIIIIIllIllIlIlllll.tagCount(); ++llllllllllllllIIIIIllIllIlIllllI) {
            final NBTTagCompound llllllllllllllIIIIIllIllIlIlllIl = llllllllllllllIIIIIllIllIlIlllll.getCompoundTagAt(llllllllllllllIIIIIllIllIlIllllI);
            final IAttributeInstance llllllllllllllIIIIIllIllIlIlllII = llllllllllllllIIIIIllIllIllIIIII.getAttributeInstanceByName(llllllllllllllIIIIIllIllIlIlllIl.getString("Name"));
            if (llllllllllllllIIIIIllIllIlIlllII != null) {
                applyModifiersToAttributeInstance(llllllllllllllIIIIIllIllIlIlllII, llllllllllllllIIIIIllIllIlIlllIl);
            }
            else {
                SharedMonsterAttributes.logger.warn(String.valueOf(new StringBuilder("Ignoring unknown attribute '").append(llllllllllllllIIIIIllIllIlIlllIl.getString("Name")).append("'")));
            }
        }
    }
    
    public static AttributeModifier readAttributeModifierFromNBT(final NBTTagCompound llllllllllllllIIIIIllIllIlIIIIIl) {
        final UUID llllllllllllllIIIIIllIllIlIIIIII = new UUID(llllllllllllllIIIIIllIllIlIIIIIl.getLong("UUIDMost"), llllllllllllllIIIIIllIllIlIIIIIl.getLong("UUIDLeast"));
        try {
            return new AttributeModifier(llllllllllllllIIIIIllIllIlIIIIII, llllllllllllllIIIIIllIllIlIIIIIl.getString("Name"), llllllllllllllIIIIIllIllIlIIIIIl.getDouble("Amount"), llllllllllllllIIIIIllIllIlIIIIIl.getInteger("Operation"));
        }
        catch (Exception llllllllllllllIIIIIllIllIIllllll) {
            SharedMonsterAttributes.logger.warn(String.valueOf(new StringBuilder("Unable to create attribute: ").append(llllllllllllllIIIIIllIllIIllllll.getMessage())));
            return null;
        }
    }
    
    static {
        __OBFID = "CL_00001695";
        logger = LogManager.getLogger();
        maxHealth = new RangedAttribute(null, "generic.maxHealth", 20.0, 0.0, Double.MAX_VALUE).setDescription("Max Health").setShouldWatch(true);
        followRange = new RangedAttribute(null, "generic.followRange", 32.0, 0.0, 2048.0).setDescription("Follow Range");
        knockbackResistance = new RangedAttribute(null, "generic.knockbackResistance", 0.0, 0.0, 1.0).setDescription("Knockback Resistance");
        movementSpeed = new RangedAttribute(null, "generic.movementSpeed", 0.699999988079071, 0.0, Double.MAX_VALUE).setDescription("Movement Speed").setShouldWatch(true);
        attackDamage = new RangedAttribute(null, "generic.attackDamage", 2.0, 0.0, Double.MAX_VALUE);
    }
    
    public static NBTTagList writeBaseAttributeMapToNBT(final BaseAttributeMap llllllllllllllIIIIIllIlllIIIlIII) {
        final NBTTagList llllllllllllllIIIIIllIlllIIIIlll = new NBTTagList();
        for (final IAttributeInstance llllllllllllllIIIIIllIlllIIIIlIl : llllllllllllllIIIIIllIlllIIIlIII.getAllAttributes()) {
            llllllllllllllIIIIIllIlllIIIIlll.appendTag(writeAttributeInstanceToNBT(llllllllllllllIIIIIllIlllIIIIlIl));
        }
        return llllllllllllllIIIIIllIlllIIIIlll;
    }
}
