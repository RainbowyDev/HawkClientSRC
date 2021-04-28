package net.minecraft.client.stream;

import net.minecraft.stats.*;

public class MetadataAchievement extends Metadata
{
    public MetadataAchievement(final Achievement llllllllllllllIIIlIIIllllllIlIll) {
        super("achievement");
        this.func_152808_a("achievement_id", llllllllllllllIIIlIIIllllllIlIll.statId);
        this.func_152808_a("achievement_name", llllllllllllllIIIlIIIllllllIlIll.getStatName().getUnformattedText());
        this.func_152808_a("achievement_description", llllllllllllllIIIlIIIllllllIlIll.getDescription());
        this.func_152807_a(String.valueOf(new StringBuilder("Achievement '").append(llllllllllllllIIIlIIIllllllIlIll.getStatName().getUnformattedText()).append("' obtained!")));
    }
    
    static {
        __OBFID = "CL_00001824";
    }
}
