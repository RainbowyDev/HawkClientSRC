package net.minecraft.client.gui;

import net.minecraft.util.*;

public class ChatLine
{
    private final /* synthetic */ int chatLineID;
    private final /* synthetic */ IChatComponent lineString;
    private final /* synthetic */ int updateCounterCreated;
    
    public int getUpdatedCounter() {
        return this.updateCounterCreated;
    }
    
    public IChatComponent getChatComponent() {
        return this.lineString;
    }
    
    public int getChatLineID() {
        return this.chatLineID;
    }
    
    public ChatLine(final int lllllllllllllllIIllIlIIlIllIIlll, final IChatComponent lllllllllllllllIIllIlIIlIllIIllI, final int lllllllllllllllIIllIlIIlIllIlIIl) {
        this.lineString = lllllllllllllllIIllIlIIlIllIIllI;
        this.updateCounterCreated = lllllllllllllllIIllIlIIlIllIIlll;
        this.chatLineID = lllllllllllllllIIllIlIIlIllIlIIl;
    }
    
    static {
        __OBFID = "CL_00000627";
    }
}
