package net.minecraft.util;

import java.util.*;
import net.minecraft.server.*;
import net.minecraft.scoreboard.*;

public class ChatComponentScore extends ChatComponentStyle
{
    private /* synthetic */ String field_179998_d;
    private final /* synthetic */ String field_180000_c;
    private final /* synthetic */ String field_179999_b;
    
    public void func_179997_b(final String llllllllllllllIlIIlllIlllIIllIII) {
        this.field_179998_d = llllllllllllllIlIIlllIlllIIllIII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("ScoreComponent{name='").append(this.field_179999_b).append('\'').append("objective='").append(this.field_180000_c).append('\'').append(", siblings=").append(this.siblings).append(", style=").append(this.getChatStyle()).append('}'));
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlIIlllIllIlllIIll) {
        if (this == llllllllllllllIlIIlllIllIlllIIll) {
            return true;
        }
        if (!(llllllllllllllIlIIlllIllIlllIIll instanceof ChatComponentScore)) {
            return false;
        }
        final ChatComponentScore llllllllllllllIlIIlllIllIlllIlIl = (ChatComponentScore)llllllllllllllIlIIlllIllIlllIIll;
        return this.field_179999_b.equals(llllllllllllllIlIIlllIllIlllIlIl.field_179999_b) && this.field_180000_c.equals(llllllllllllllIlIIlllIllIlllIlIl.field_180000_c) && super.equals(llllllllllllllIlIIlllIllIlllIIll);
    }
    
    public ChatComponentScore(final String llllllllllllllIlIIlllIlllIlIIIll, final String llllllllllllllIlIIlllIlllIlIIIlI) {
        this.field_179998_d = "";
        this.field_179999_b = llllllllllllllIlIIlllIlllIlIIIll;
        this.field_180000_c = llllllllllllllIlIIlllIlllIlIIIlI;
    }
    
    public String func_179994_h() {
        return this.field_180000_c;
    }
    
    public ChatComponentScore func_179996_i() {
        final ChatComponentScore llllllllllllllIlIIlllIlllIIIIIIl = new ChatComponentScore(this.field_179999_b, this.field_180000_c);
        llllllllllllllIlIIlllIlllIIIIIIl.func_179997_b(this.field_179998_d);
        llllllllllllllIlIIlllIlllIIIIIIl.setChatStyle(this.getChatStyle().createShallowCopy());
        for (final IChatComponent llllllllllllllIlIIlllIllIlllllll : this.getSiblings()) {
            llllllllllllllIlIIlllIlllIIIIIIl.appendSibling(llllllllllllllIlIIlllIllIlllllll.createCopy());
        }
        return llllllllllllllIlIIlllIlllIIIIIIl;
    }
    
    public String func_179995_g() {
        return this.field_179999_b;
    }
    
    @Override
    public String getUnformattedTextForChat() {
        final MinecraftServer llllllllllllllIlIIlllIlllIIIllll = MinecraftServer.getServer();
        if (llllllllllllllIlIIlllIlllIIIllll != null && llllllllllllllIlIIlllIlllIIIllll.func_175578_N() && StringUtils.isNullOrEmpty(this.field_179998_d)) {
            final Scoreboard llllllllllllllIlIIlllIlllIIIlllI = llllllllllllllIlIIlllIlllIIIllll.worldServerForDimension(0).getScoreboard();
            final ScoreObjective llllllllllllllIlIIlllIlllIIIllIl = llllllllllllllIlIIlllIlllIIIlllI.getObjective(this.field_180000_c);
            if (llllllllllllllIlIIlllIlllIIIlllI.func_178819_b(this.field_179999_b, llllllllllllllIlIIlllIlllIIIllIl)) {
                final Score llllllllllllllIlIIlllIlllIIIllII = llllllllllllllIlIIlllIlllIIIlllI.getValueFromObjective(this.field_179999_b, llllllllllllllIlIIlllIlllIIIllIl);
                this.func_179997_b(String.format("%d", llllllllllllllIlIIlllIlllIIIllII.getScorePoints()));
            }
            else {
                this.field_179998_d = "";
            }
        }
        return this.field_179998_d;
    }
    
    static {
        __OBFID = "CL_00002309";
    }
    
    @Override
    public IChatComponent createCopy() {
        return this.func_179996_i();
    }
}
