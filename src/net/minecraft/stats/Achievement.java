package net.minecraft.stats;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.*;

public class Achievement extends StatBase
{
    public final /* synthetic */ ItemStack theItemStack;
    public final /* synthetic */ int displayRow;
    private /* synthetic */ boolean isSpecial;
    public final /* synthetic */ int displayColumn;
    public final /* synthetic */ Achievement parentAchievement;
    private /* synthetic */ IStatStringFormat statStringFormatter;
    private final /* synthetic */ String achievementDescription;
    
    public String getDescription() {
        return (this.statStringFormatter != null) ? this.statStringFormatter.formatString(StatCollector.translateToLocal(this.achievementDescription)) : StatCollector.translateToLocal(this.achievementDescription);
    }
    
    public Achievement(final String llllllllllllllllllllIlIIlIIlllll, final String llllllllllllllllllllIlIIlIIlIlll, final int llllllllllllllllllllIlIIlIIlllIl, final int llllllllllllllllllllIlIIlIIlIlIl, final Item llllllllllllllllllllIlIIlIIlIlII, final Achievement llllllllllllllllllllIlIIlIIllIlI) {
        this(llllllllllllllllllllIlIIlIIlllll, llllllllllllllllllllIlIIlIIlIlll, llllllllllllllllllllIlIIlIIlllIl, llllllllllllllllllllIlIIlIIlIlIl, new ItemStack(llllllllllllllllllllIlIIlIIlIlII), llllllllllllllllllllIlIIlIIllIlI);
    }
    
    @Override
    public StatBase initIndependentStat() {
        return this.func_180789_a();
    }
    
    public Achievement func_180788_c() {
        super.registerStat();
        AchievementList.achievementList.add(this);
        return this;
    }
    
    static {
        __OBFID = "CL_00001466";
    }
    
    @Override
    public boolean isAchievement() {
        return true;
    }
    
    public Achievement setStatStringFormatter(final IStatStringFormat llllllllllllllllllllIlIIIlIIlIlI) {
        this.statStringFormatter = llllllllllllllllllllIlIIIlIIlIlI;
        return this;
    }
    
    @Override
    public IChatComponent getStatName() {
        final IChatComponent llllllllllllllllllllIlIIIlIllIll = super.getStatName();
        llllllllllllllllllllIlIIIlIllIll.getChatStyle().setColor(this.getSpecial() ? EnumChatFormatting.DARK_PURPLE : EnumChatFormatting.GREEN);
        return llllllllllllllllllllIlIIIlIllIll;
    }
    
    @Override
    public StatBase registerStat() {
        return this.func_180788_c();
    }
    
    public Achievement func_180789_a() {
        this.isIndependent = true;
        return this;
    }
    
    public Achievement setSpecial() {
        this.isSpecial = true;
        return this;
    }
    
    public Achievement(final String llllllllllllllllllllIlIIIlllIlIl, final String llllllllllllllllllllIlIIIllIllIl, final int llllllllllllllllllllIlIIIlllIIll, final int llllllllllllllllllllIlIIIllIlIll, final ItemStack llllllllllllllllllllIlIIIllIlIlI, final Achievement llllllllllllllllllllIlIIIllIlIIl) {
        super(llllllllllllllllllllIlIIIlllIlIl, new ChatComponentTranslation(String.valueOf(new StringBuilder("achievement.").append(llllllllllllllllllllIlIIIllIllIl)), new Object[0]));
        this.theItemStack = llllllllllllllllllllIlIIIllIlIlI;
        this.achievementDescription = String.valueOf(new StringBuilder("achievement.").append(llllllllllllllllllllIlIIIllIllIl).append(".desc"));
        this.displayColumn = llllllllllllllllllllIlIIIlllIIll;
        this.displayRow = llllllllllllllllllllIlIIIllIlIll;
        if (llllllllllllllllllllIlIIIlllIIll < AchievementList.minDisplayColumn) {
            AchievementList.minDisplayColumn = llllllllllllllllllllIlIIIlllIIll;
        }
        if (llllllllllllllllllllIlIIIllIlIll < AchievementList.minDisplayRow) {
            AchievementList.minDisplayRow = llllllllllllllllllllIlIIIllIlIll;
        }
        if (llllllllllllllllllllIlIIIlllIIll > AchievementList.maxDisplayColumn) {
            AchievementList.maxDisplayColumn = llllllllllllllllllllIlIIIlllIIll;
        }
        if (llllllllllllllllllllIlIIIllIlIll > AchievementList.maxDisplayRow) {
            AchievementList.maxDisplayRow = llllllllllllllllllllIlIIIllIlIll;
        }
        this.parentAchievement = llllllllllllllllllllIlIIIllIlIIl;
    }
    
    @Override
    public StatBase func_150953_b(final Class llllllllllllllllllllIlIIIlIIIIIl) {
        return this.func_180787_a(llllllllllllllllllllIlIIIlIIIIIl);
    }
    
    public Achievement func_180787_a(final Class llllllllllllllllllllIlIIIlIlIIll) {
        return (Achievement)super.func_150953_b(llllllllllllllllllllIlIIIlIlIIll);
    }
    
    public Achievement(final String llllllllllllllllllllIlIIlIIIIIll, final String llllllllllllllllllllIlIIlIIIIIlI, final int llllllllllllllllllllIlIIlIIIlIII, final int llllllllllllllllllllIlIIlIIIIIII, final Block llllllllllllllllllllIlIIIlllllll, final Achievement llllllllllllllllllllIlIIlIIIIlIl) {
        this(llllllllllllllllllllIlIIlIIIIIll, llllllllllllllllllllIlIIlIIIIIlI, llllllllllllllllllllIlIIlIIIlIII, llllllllllllllllllllIlIIlIIIIIII, new ItemStack(llllllllllllllllllllIlIIIlllllll), llllllllllllllllllllIlIIlIIIIlIl);
    }
    
    public boolean getSpecial() {
        return this.isSpecial;
    }
}
