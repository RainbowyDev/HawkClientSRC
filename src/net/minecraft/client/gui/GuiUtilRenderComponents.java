package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public class GuiUtilRenderComponents
{
    static {
        __OBFID = "CL_00001957";
    }
    
    public static String func_178909_a(final String llllllllllllllIIIIllIlIllllllllI, final boolean llllllllllllllIIIIllIlIlllllllIl) {
        return (!llllllllllllllIIIIllIlIlllllllIl && !Minecraft.getMinecraft().gameSettings.chatColours) ? EnumChatFormatting.getTextWithoutFormattingCodes(llllllllllllllIIIIllIlIllllllllI) : llllllllllllllIIIIllIlIllllllllI;
    }
    
    public static List func_178908_a(final IChatComponent llllllllllllllIIIIllIlIllllIIlll, final int llllllllllllllIIIIllIlIllllIIllI, final FontRenderer llllllllllllllIIIIllIlIlllIIllIl, final boolean llllllllllllllIIIIllIlIllllIIlII, final boolean llllllllllllllIIIIllIlIlllIIlIll) {
        int llllllllllllllIIIIllIlIllllIIIlI = 0;
        ChatComponentText llllllllllllllIIIIllIlIllllIIIIl = new ChatComponentText("");
        final ArrayList llllllllllllllIIIIllIlIllllIIIII = Lists.newArrayList();
        final ArrayList llllllllllllllIIIIllIlIlllIlllll = Lists.newArrayList((Iterable)llllllllllllllIIIIllIlIllllIIlll);
        for (int llllllllllllllIIIIllIlIlllIllllI = 0; llllllllllllllIIIIllIlIlllIllllI < llllllllllllllIIIIllIlIlllIlllll.size(); ++llllllllllllllIIIIllIlIlllIllllI) {
            final IChatComponent llllllllllllllIIIIllIlIlllIlllIl = llllllllllllllIIIIllIlIlllIlllll.get(llllllllllllllIIIIllIlIlllIllllI);
            String llllllllllllllIIIIllIlIlllIlllII = llllllllllllllIIIIllIlIlllIlllIl.getUnformattedTextForChat();
            boolean llllllllllllllIIIIllIlIlllIllIll = false;
            if (llllllllllllllIIIIllIlIlllIlllII.contains("\n")) {
                final int llllllllllllllIIIIllIlIlllIllIII = llllllllllllllIIIIllIlIlllIlllII.indexOf(10);
                final String llllllllllllllIIIIllIlIlllIllIlI = llllllllllllllIIIIllIlIlllIlllII.substring(llllllllllllllIIIIllIlIlllIllIII + 1);
                llllllllllllllIIIIllIlIlllIlllII = llllllllllllllIIIIllIlIlllIlllII.substring(0, llllllllllllllIIIIllIlIlllIllIII + 1);
                final ChatComponentText llllllllllllllIIIIllIlIlllIlIlll = new ChatComponentText(llllllllllllllIIIIllIlIlllIllIlI);
                llllllllllllllIIIIllIlIlllIlIlll.setChatStyle(llllllllllllllIIIIllIlIlllIlllIl.getChatStyle().createShallowCopy());
                llllllllllllllIIIIllIlIlllIlllll.add(llllllllllllllIIIIllIlIlllIllllI + 1, llllllllllllllIIIIllIlIlllIlIlll);
                llllllllllllllIIIIllIlIlllIllIll = true;
            }
            final String llllllllllllllIIIIllIlIlllIlIllI = func_178909_a(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIIllIlIlllIlllIl.getChatStyle().getFormattingCode())).append(llllllllllllllIIIIllIlIlllIlllII)), llllllllllllllIIIIllIlIlllIIlIll);
            final String llllllllllllllIIIIllIlIlllIllIIl = llllllllllllllIIIIllIlIlllIlIllI.endsWith("\n") ? llllllllllllllIIIIllIlIlllIlIllI.substring(0, llllllllllllllIIIIllIlIlllIlIllI.length() - 1) : llllllllllllllIIIIllIlIlllIlIllI;
            int llllllllllllllIIIIllIlIlllIlIlIl = llllllllllllllIIIIllIlIlllIIllIl.getStringWidth(llllllllllllllIIIIllIlIlllIllIIl);
            ChatComponentText llllllllllllllIIIIllIlIlllIlIlII = new ChatComponentText(llllllllllllllIIIIllIlIlllIllIIl);
            llllllllllllllIIIIllIlIlllIlIlII.setChatStyle(llllllllllllllIIIIllIlIlllIlllIl.getChatStyle().createShallowCopy());
            if (llllllllllllllIIIIllIlIllllIIIlI + llllllllllllllIIIIllIlIlllIlIlIl > llllllllllllllIIIIllIlIllllIIllI) {
                String llllllllllllllIIIIllIlIlllIlIIll = llllllllllllllIIIIllIlIlllIIllIl.trimStringToWidth(llllllllllllllIIIIllIlIlllIlIllI, llllllllllllllIIIIllIlIllllIIllI - llllllllllllllIIIIllIlIllllIIIlI, false);
                String llllllllllllllIIIIllIlIlllIlIIlI = (llllllllllllllIIIIllIlIlllIlIIll.length() < llllllllllllllIIIIllIlIlllIlIllI.length()) ? llllllllllllllIIIIllIlIlllIlIllI.substring(llllllllllllllIIIIllIlIlllIlIIll.length()) : null;
                if (llllllllllllllIIIIllIlIlllIlIIlI != null && llllllllllllllIIIIllIlIlllIlIIlI.length() > 0) {
                    int llllllllllllllIIIIllIlIlllIlIIIl = llllllllllllllIIIIllIlIlllIlIIll.lastIndexOf(" ");
                    if (llllllllllllllIIIIllIlIlllIlIIIl >= 0 && llllllllllllllIIIIllIlIlllIIllIl.getStringWidth(llllllllllllllIIIIllIlIlllIlIllI.substring(0, llllllllllllllIIIIllIlIlllIlIIIl)) > 0) {
                        llllllllllllllIIIIllIlIlllIlIIll = llllllllllllllIIIIllIlIlllIlIllI.substring(0, llllllllllllllIIIIllIlIlllIlIIIl);
                        if (llllllllllllllIIIIllIlIllllIIlII) {
                            ++llllllllllllllIIIIllIlIlllIlIIIl;
                        }
                        llllllllllllllIIIIllIlIlllIlIIlI = llllllllllllllIIIIllIlIlllIlIllI.substring(llllllllllllllIIIIllIlIlllIlIIIl);
                    }
                    else if (llllllllllllllIIIIllIlIllllIIIlI > 0 && !llllllllllllllIIIIllIlIlllIlIllI.contains(" ")) {
                        llllllllllllllIIIIllIlIlllIlIIll = "";
                        llllllllllllllIIIIllIlIlllIlIIlI = llllllllllllllIIIIllIlIlllIlIllI;
                    }
                    final ChatComponentText llllllllllllllIIIIllIlIlllIlIIII = new ChatComponentText(llllllllllllllIIIIllIlIlllIlIIlI);
                    llllllllllllllIIIIllIlIlllIlIIII.setChatStyle(llllllllllllllIIIIllIlIlllIlllIl.getChatStyle().createShallowCopy());
                    llllllllllllllIIIIllIlIlllIlllll.add(llllllllllllllIIIIllIlIlllIllllI + 1, llllllllllllllIIIIllIlIlllIlIIII);
                }
                llllllllllllllIIIIllIlIlllIlIlIl = llllllllllllllIIIIllIlIlllIIllIl.getStringWidth(llllllllllllllIIIIllIlIlllIlIIll);
                llllllllllllllIIIIllIlIlllIlIlII = new ChatComponentText(llllllllllllllIIIIllIlIlllIlIIll);
                llllllllllllllIIIIllIlIlllIlIlII.setChatStyle(llllllllllllllIIIIllIlIlllIlllIl.getChatStyle().createShallowCopy());
                llllllllllllllIIIIllIlIlllIllIll = true;
            }
            if (llllllllllllllIIIIllIlIllllIIIlI + llllllllllllllIIIIllIlIlllIlIlIl <= llllllllllllllIIIIllIlIllllIIllI) {
                llllllllllllllIIIIllIlIllllIIIlI += llllllllllllllIIIIllIlIlllIlIlIl;
                llllllllllllllIIIIllIlIllllIIIIl.appendSibling(llllllllllllllIIIIllIlIlllIlIlII);
            }
            else {
                llllllllllllllIIIIllIlIlllIllIll = true;
            }
            if (llllllllllllllIIIIllIlIlllIllIll) {
                llllllllllllllIIIIllIlIllllIIIII.add(llllllllllllllIIIIllIlIllllIIIIl);
                llllllllllllllIIIIllIlIllllIIIlI = 0;
                llllllllllllllIIIIllIlIllllIIIIl = new ChatComponentText("");
            }
        }
        llllllllllllllIIIIllIlIllllIIIII.add(llllllllllllllIIIIllIlIllllIIIIl);
        return llllllllllllllIIIIllIlIllllIIIII;
    }
}
