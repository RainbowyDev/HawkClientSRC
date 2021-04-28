package net.minecraft.util;

import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.command.*;

public class ChatComponentProcessor
{
    public static IChatComponent func_179985_a(final ICommandSender lllllllllllllllllIllIlllIIlllIll, final IChatComponent lllllllllllllllllIllIlllIIlIllII, final Entity lllllllllllllllllIllIlllIIlllIIl) throws CommandException {
        Object lllllllllllllllllIllIlllIIlllIII = null;
        if (lllllllllllllllllIllIlllIIlIllII instanceof ChatComponentScore) {
            final ChatComponentScore lllllllllllllllllIllIlllIIllIlll = (ChatComponentScore)lllllllllllllllllIllIlllIIlIllII;
            String lllllllllllllllllIllIlllIIllIllI = lllllllllllllllllIllIlllIIllIlll.func_179995_g();
            if (PlayerSelector.hasArguments(lllllllllllllllllIllIlllIIllIllI)) {
                final List lllllllllllllllllIllIlllIIllIlIl = PlayerSelector.func_179656_b(lllllllllllllllllIllIlllIIlllIll, lllllllllllllllllIllIlllIIllIllI, Entity.class);
                if (lllllllllllllllllIllIlllIIllIlIl.size() != 1) {
                    throw new EntityNotFoundException();
                }
                lllllllllllllllllIllIlllIIllIllI = lllllllllllllllllIllIlllIIllIlIl.get(0).getName();
            }
            lllllllllllllllllIllIlllIIlllIII = ((lllllllllllllllllIllIlllIIlllIIl != null && lllllllllllllllllIllIlllIIllIllI.equals("*")) ? new ChatComponentScore(lllllllllllllllllIllIlllIIlllIIl.getName(), lllllllllllllllllIllIlllIIllIlll.func_179994_h()) : new ChatComponentScore(lllllllllllllllllIllIlllIIllIllI, lllllllllllllllllIllIlllIIllIlll.func_179994_h()));
            ((ChatComponentScore)lllllllllllllllllIllIlllIIlllIII).func_179997_b(lllllllllllllllllIllIlllIIllIlll.getUnformattedTextForChat());
        }
        else if (lllllllllllllllllIllIlllIIlIllII instanceof ChatComponentSelector) {
            final String lllllllllllllllllIllIlllIIllIlII = ((ChatComponentSelector)lllllllllllllllllIllIlllIIlIllII).func_179992_g();
            lllllllllllllllllIllIlllIIlllIII = PlayerSelector.func_150869_b(lllllllllllllllllIllIlllIIlllIll, lllllllllllllllllIllIlllIIllIlII);
            if (lllllllllllllllllIllIlllIIlllIII == null) {
                lllllllllllllllllIllIlllIIlllIII = new ChatComponentText("");
            }
        }
        else if (lllllllllllllllllIllIlllIIlIllII instanceof ChatComponentText) {
            lllllllllllllllllIllIlllIIlllIII = new ChatComponentText(((ChatComponentText)lllllllllllllllllIllIlllIIlIllII).getChatComponentText_TextValue());
        }
        else {
            if (!(lllllllllllllllllIllIlllIIlIllII instanceof ChatComponentTranslation)) {
                return lllllllllllllllllIllIlllIIlIllII;
            }
            final Object[] lllllllllllllllllIllIlllIIllIIll = ((ChatComponentTranslation)lllllllllllllllllIllIlllIIlIllII).getFormatArgs();
            for (int lllllllllllllllllIllIlllIIllIIlI = 0; lllllllllllllllllIllIlllIIllIIlI < lllllllllllllllllIllIlllIIllIIll.length; ++lllllllllllllllllIllIlllIIllIIlI) {
                final Object lllllllllllllllllIllIlllIIllIIIl = lllllllllllllllllIllIlllIIllIIll[lllllllllllllllllIllIlllIIllIIlI];
                if (lllllllllllllllllIllIlllIIllIIIl instanceof IChatComponent) {
                    lllllllllllllllllIllIlllIIllIIll[lllllllllllllllllIllIlllIIllIIlI] = func_179985_a(lllllllllllllllllIllIlllIIlllIll, (IChatComponent)lllllllllllllllllIllIlllIIllIIIl, lllllllllllllllllIllIlllIIlllIIl);
                }
            }
            lllllllllllllllllIllIlllIIlllIII = new ChatComponentTranslation(((ChatComponentTranslation)lllllllllllllllllIllIlllIIlIllII).getKey(), lllllllllllllllllIllIlllIIllIIll);
        }
        final ChatStyle lllllllllllllllllIllIlllIIllIIII = lllllllllllllllllIllIlllIIlIllII.getChatStyle();
        if (lllllllllllllllllIllIlllIIllIIII != null) {
            ((IChatComponent)lllllllllllllllllIllIlllIIlllIII).setChatStyle(lllllllllllllllllIllIlllIIllIIII.createShallowCopy());
        }
        for (final IChatComponent lllllllllllllllllIllIlllIIlIlllI : lllllllllllllllllIllIlllIIlIllII.getSiblings()) {
            ((IChatComponent)lllllllllllllllllIllIlllIIlllIII).appendSibling(func_179985_a(lllllllllllllllllIllIlllIIlllIll, lllllllllllllllllIllIlllIIlIlllI, lllllllllllllllllIllIlllIIlllIIl));
        }
        return (IChatComponent)lllllllllllllllllIllIlllIIlllIII;
    }
    
    static {
        __OBFID = "CL_00002310";
    }
}
