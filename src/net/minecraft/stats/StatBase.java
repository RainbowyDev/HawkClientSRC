package net.minecraft.stats;

import net.minecraft.scoreboard.*;
import java.text.*;
import net.minecraft.util.*;
import net.minecraft.event.*;
import java.util.*;

public class StatBase
{
    private static /* synthetic */ NumberFormat numberFormat;
    private final /* synthetic */ IChatComponent statName;
    public static /* synthetic */ IStatType timeStatType;
    private /* synthetic */ Class field_150956_d;
    public final /* synthetic */ String statId;
    private final /* synthetic */ IScoreObjectiveCriteria field_150957_c;
    public static /* synthetic */ IStatType simpleStatType;
    private static /* synthetic */ DecimalFormat decimalFormat;
    public static /* synthetic */ IStatType field_111202_k;
    public static /* synthetic */ IStatType distanceStatType;
    private final /* synthetic */ IStatType type;
    public /* synthetic */ boolean isIndependent;
    
    public StatBase(final String lllllllllllllllIlllIIlIIIIIlIIll, final IChatComponent lllllllllllllllIlllIIlIIIIIlIIlI, final IStatType lllllllllllllllIlllIIlIIIIIlIlIl) {
        this.statId = lllllllllllllllIlllIIlIIIIIlIIll;
        this.statName = lllllllllllllllIlllIIlIIIIIlIIlI;
        this.type = lllllllllllllllIlllIIlIIIIIlIlIl;
        this.field_150957_c = new ObjectiveStat(this);
        IScoreObjectiveCriteria.INSTANCES.put(this.field_150957_c.getName(), this.field_150957_c);
    }
    
    public StatBase registerStat() {
        if (StatList.oneShotStats.containsKey(this.statId)) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Duplicate stat id: \"").append(StatList.oneShotStats.get(this.statId).statName).append("\" and \"").append(this.statName).append("\" at id ").append(this.statId)));
        }
        StatList.allStats.add(this);
        StatList.oneShotStats.put(this.statId, this);
        return this;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Stat{id=").append(this.statId).append(", nameId=").append(this.statName).append(", awardLocallyOnly=").append(this.isIndependent).append(", formatter=").append(this.type).append(", objectiveCriteria=").append(this.field_150957_c).append('}'));
    }
    
    public Class func_150954_l() {
        return this.field_150956_d;
    }
    
    public IChatComponent func_150955_j() {
        final IChatComponent lllllllllllllllIlllIIIllllllIIII = this.getStatName();
        final IChatComponent lllllllllllllllIlllIIIlllllIllll = new ChatComponentText("[").appendSibling(lllllllllllllllIlllIIIllllllIIII).appendText("]");
        lllllllllllllllIlllIIIlllllIllll.setChatStyle(lllllllllllllllIlllIIIllllllIIII.getChatStyle());
        return lllllllllllllllIlllIIIlllllIllll;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIlllIIIlllllIIlII) {
        if (this == lllllllllllllllIlllIIIlllllIIlII) {
            return true;
        }
        if (lllllllllllllllIlllIIIlllllIIlII != null && this.getClass() == lllllllllllllllIlllIIIlllllIIlII.getClass()) {
            final StatBase lllllllllllllllIlllIIIlllllIIllI = (StatBase)lllllllllllllllIlllIIIlllllIIlII;
            return this.statId.equals(lllllllllllllllIlllIIIlllllIIllI.statId);
        }
        return false;
    }
    
    public IScoreObjectiveCriteria func_150952_k() {
        return this.field_150957_c;
    }
    
    public IChatComponent getStatName() {
        final IChatComponent lllllllllllllllIlllIIIllllllIlll = this.statName.createCopy();
        lllllllllllllllIlllIIIllllllIlll.getChatStyle().setColor(EnumChatFormatting.GRAY);
        lllllllllllllllIlllIIIllllllIlll.getChatStyle().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ACHIEVEMENT, new ChatComponentText(this.statId)));
        return lllllllllllllllIlllIIIllllllIlll;
    }
    
    public StatBase initIndependentStat() {
        this.isIndependent = true;
        return this;
    }
    
    @Override
    public int hashCode() {
        return this.statId.hashCode();
    }
    
    static {
        __OBFID = "CL_00001472";
        StatBase.numberFormat = NumberFormat.getIntegerInstance(Locale.US);
        StatBase.simpleStatType = new IStatType() {
            @Override
            public String format(final int llllllllllllllllllIIlllIlllIIIIl) {
                return StatBase.numberFormat.format(llllllllllllllllllIIlllIlllIIIIl);
            }
            
            static {
                __OBFID = "CL_00001473";
            }
        };
        StatBase.decimalFormat = new DecimalFormat("########0.00");
        StatBase.timeStatType = new IStatType() {
            @Override
            public String format(final int lllllllllllllllIIIIllIIIIIIIlIII) {
                final double lllllllllllllllIIIIllIIIIIIIIlll = lllllllllllllllIIIIllIIIIIIIlIII / 20.0;
                final double lllllllllllllllIIIIllIIIIIIIIllI = lllllllllllllllIIIIllIIIIIIIIlll / 60.0;
                final double lllllllllllllllIIIIllIIIIIIIIlIl = lllllllllllllllIIIIllIIIIIIIIllI / 60.0;
                final double lllllllllllllllIIIIllIIIIIIIIlII = lllllllllllllllIIIIllIIIIIIIIlIl / 24.0;
                final double lllllllllllllllIIIIllIIIIIIIIIll = lllllllllllllllIIIIllIIIIIIIIlII / 365.0;
                return (lllllllllllllllIIIIllIIIIIIIIIll > 0.5) ? String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(lllllllllllllllIIIIllIIIIIIIIIll))).append(" y")) : ((lllllllllllllllIIIIllIIIIIIIIlII > 0.5) ? String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(lllllllllllllllIIIIllIIIIIIIIlII))).append(" d")) : ((lllllllllllllllIIIIllIIIIIIIIlIl > 0.5) ? String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(lllllllllllllllIIIIllIIIIIIIIlIl))).append(" h")) : ((lllllllllllllllIIIIllIIIIIIIIllI > 0.5) ? String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(lllllllllllllllIIIIllIIIIIIIIllI))).append(" m")) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIIllIIIIIIIIlll)).append(" s")))));
            }
            
            static {
                __OBFID = "CL_00001474";
            }
        };
        StatBase.distanceStatType = new IStatType() {
            static {
                __OBFID = "CL_00001475";
            }
            
            @Override
            public String format(final int lllllllllllllllllllllllllllIlIII) {
                final double lllllllllllllllllllllllllllIIlll = lllllllllllllllllllllllllllIlIII / 100.0;
                final double lllllllllllllllllllllllllllIIllI = lllllllllllllllllllllllllllIIlll / 1000.0;
                return (lllllllllllllllllllllllllllIIllI > 0.5) ? String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(lllllllllllllllllllllllllllIIllI))).append(" km")) : ((lllllllllllllllllllllllllllIIlll > 0.5) ? String.valueOf(new StringBuilder(String.valueOf(StatBase.decimalFormat.format(lllllllllllllllllllllllllllIIlll))).append(" m")) : String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllllllllllllIlIII)).append(" cm")));
            }
        };
        StatBase.field_111202_k = new IStatType() {
            @Override
            public String format(final int lllllllllllllllIlllIIlIIIIlIlIll) {
                return StatBase.decimalFormat.format(lllllllllllllllIlllIIlIIIIlIlIll * 0.1);
            }
            
            static {
                __OBFID = "CL_00001476";
            }
        };
    }
    
    public boolean isAchievement() {
        return false;
    }
    
    public StatBase func_150953_b(final Class lllllllllllllllIlllIIIllllIlIIIl) {
        this.field_150956_d = lllllllllllllllIlllIIIllllIlIIIl;
        return this;
    }
    
    public String func_75968_a(final int lllllllllllllllIlllIIIllllllllIl) {
        return this.type.format(lllllllllllllllIlllIIIllllllllIl);
    }
    
    public StatBase(final String lllllllllllllllIlllIIlIIIIIIllII, final IChatComponent lllllllllllllllIlllIIlIIIIIIlIll) {
        this(lllllllllllllllIlllIIlIIIIIIllII, lllllllllllllllIlllIIlIIIIIIlIll, StatBase.simpleStatType);
    }
}
