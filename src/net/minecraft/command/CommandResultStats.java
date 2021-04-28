package net.minecraft.command;

import net.minecraft.nbt.*;

public class CommandResultStats
{
    private static final /* synthetic */ int field_179676_a;
    private /* synthetic */ String[] field_179675_c;
    private /* synthetic */ String[] field_179673_d;
    private static final /* synthetic */ String[] field_179674_b;
    
    public void func_179671_a(final CommandResultStats lllllllllllllllllIIIIllIlIllllIl) {
        for (final Type lllllllllllllllllIIIIllIlIlllIIl : Type.values()) {
            func_179667_a(this, lllllllllllllllllIIIIllIlIlllIIl, lllllllllllllllllIIIIllIlIllllIl.field_179675_c[lllllllllllllllllIIIIllIlIlllIIl.func_179636_a()], lllllllllllllllllIIIIllIlIllllIl.field_179673_d[lllllllllllllllllIIIIllIlIlllIIl.func_179636_a()]);
        }
    }
    
    private static void func_179669_a(final CommandResultStats lllllllllllllllllIIIIllIllIIlIll, final Type lllllllllllllllllIIIIllIllIIlIlI) {
        if (lllllllllllllllllIIIIllIllIIlIll.field_179675_c != CommandResultStats.field_179674_b && lllllllllllllllllIIIIllIllIIlIll.field_179673_d != CommandResultStats.field_179674_b) {
            lllllllllllllllllIIIIllIllIIlIll.field_179675_c[lllllllllllllllllIIIIllIllIIlIlI.func_179636_a()] = null;
            lllllllllllllllllIIIIllIllIIlIll.field_179673_d[lllllllllllllllllIIIIllIllIIlIlI.func_179636_a()] = null;
            boolean lllllllllllllllllIIIIllIllIlIIII = true;
            for (final Type lllllllllllllllllIIIIllIllIIllII : Type.values()) {
                if (lllllllllllllllllIIIIllIllIIlIll.field_179675_c[lllllllllllllllllIIIIllIllIIllII.func_179636_a()] != null && lllllllllllllllllIIIIllIllIIlIll.field_179673_d[lllllllllllllllllIIIIllIllIIllII.func_179636_a()] != null) {
                    lllllllllllllllllIIIIllIllIlIIII = false;
                    break;
                }
            }
            if (lllllllllllllllllIIIIllIllIlIIII) {
                lllllllllllllllllIIIIllIllIIlIll.field_179675_c = CommandResultStats.field_179674_b;
                lllllllllllllllllIIIIllIllIIlIll.field_179673_d = CommandResultStats.field_179674_b;
            }
        }
    }
    
    public void func_179670_b(final NBTTagCompound lllllllllllllllllIIIIllIlllIllIl) {
        final NBTTagCompound lllllllllllllllllIIIIllIllllIlIl = new NBTTagCompound();
        for (final Type lllllllllllllllllIIIIllIllllIIIl : Type.values()) {
            final String lllllllllllllllllIIIIllIllllIIII = this.field_179675_c[lllllllllllllllllIIIIllIllllIIIl.func_179636_a()];
            final String lllllllllllllllllIIIIllIlllIllll = this.field_179673_d[lllllllllllllllllIIIIllIllllIIIl.func_179636_a()];
            if (lllllllllllllllllIIIIllIllllIIII != null && lllllllllllllllllIIIIllIlllIllll != null) {
                lllllllllllllllllIIIIllIllllIlIl.setString(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIIIllIllllIIIl.func_179637_b())).append("Name")), lllllllllllllllllIIIIllIllllIIII);
                lllllllllllllllllIIIIllIllllIlIl.setString(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIIIllIllllIIIl.func_179637_b())).append("Objective")), lllllllllllllllllIIIIllIlllIllll);
            }
        }
        if (!lllllllllllllllllIIIIllIllllIlIl.hasNoTags()) {
            lllllllllllllllllIIIIllIlllIllIl.setTag("CommandStats", lllllllllllllllllIIIIllIllllIlIl);
        }
    }
    
    public static void func_179667_a(final CommandResultStats lllllllllllllllllIIIIllIlllIIIIl, final Type lllllllllllllllllIIIIllIllIlllII, final String lllllllllllllllllIIIIllIllIlllll, final String lllllllllllllllllIIIIllIllIllllI) {
        if (lllllllllllllllllIIIIllIllIlllll != null && lllllllllllllllllIIIIllIllIlllll.length() != 0 && lllllllllllllllllIIIIllIllIllllI != null && lllllllllllllllllIIIIllIllIllllI.length() != 0) {
            if (lllllllllllllllllIIIIllIlllIIIIl.field_179675_c == CommandResultStats.field_179674_b || lllllllllllllllllIIIIllIlllIIIIl.field_179673_d == CommandResultStats.field_179674_b) {
                lllllllllllllllllIIIIllIlllIIIIl.field_179675_c = new String[CommandResultStats.field_179676_a];
                lllllllllllllllllIIIIllIlllIIIIl.field_179673_d = new String[CommandResultStats.field_179676_a];
            }
            lllllllllllllllllIIIIllIlllIIIIl.field_179675_c[lllllllllllllllllIIIIllIllIlllII.func_179636_a()] = lllllllllllllllllIIIIllIllIlllll;
            lllllllllllllllllIIIIllIlllIIIIl.field_179673_d[lllllllllllllllllIIIIllIllIlllII.func_179636_a()] = lllllllllllllllllIIIIllIllIllllI;
        }
        else {
            func_179669_a(lllllllllllllllllIIIIllIlllIIIIl, lllllllllllllllllIIIIllIllIlllII);
        }
    }
    
    static {
        __OBFID = "CL_00002364";
        field_179676_a = Type.values().length;
        field_179674_b = new String[CommandResultStats.field_179676_a];
    }
    
    public CommandResultStats() {
        this.field_179675_c = CommandResultStats.field_179674_b;
        this.field_179673_d = CommandResultStats.field_179674_b;
    }
    
    public void func_179668_a(final NBTTagCompound lllllllllllllllllIIIIlllIIIIlIlI) {
        if (lllllllllllllllllIIIIlllIIIIlIlI.hasKey("CommandStats", 10)) {
            final NBTTagCompound lllllllllllllllllIIIIlllIIIlIlII = lllllllllllllllllIIIIlllIIIIlIlI.getCompoundTag("CommandStats");
            for (final Type lllllllllllllllllIIIIlllIIIlIIII : Type.values()) {
                final String lllllllllllllllllIIIIlllIIIIllll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIIIlllIIIlIIII.func_179637_b())).append("Name"));
                final String lllllllllllllllllIIIIlllIIIIlllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllIIIIlllIIIlIIII.func_179637_b())).append("Objective"));
                if (lllllllllllllllllIIIIlllIIIlIlII.hasKey(lllllllllllllllllIIIIlllIIIIllll, 8) && lllllllllllllllllIIIIlllIIIlIlII.hasKey(lllllllllllllllllIIIIlllIIIIlllI, 8)) {
                    final String lllllllllllllllllIIIIlllIIIIllIl = lllllllllllllllllIIIIlllIIIlIlII.getString(lllllllllllllllllIIIIlllIIIIllll);
                    final String lllllllllllllllllIIIIlllIIIIllII = lllllllllllllllllIIIIlllIIIlIlII.getString(lllllllllllllllllIIIIlllIIIIlllI);
                    func_179667_a(this, lllllllllllllllllIIIIlllIIIlIIII, lllllllllllllllllIIIIlllIIIIllIl, lllllllllllllllllIIIIlllIIIIllII);
                }
            }
        }
    }
    
    public void func_179672_a(final ICommandSender lllllllllllllllllIIIIlllIIlIlIlI, final Type lllllllllllllllllIIIIlllIIllIlIl, final int lllllllllllllllllIIIIlllIIllIlII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/command/CommandResultStats.field_179675_c:[Ljava/lang/String;
        //     4: aload_2         /* lllllllllllllllllIIIIlllIIlIlIIl */
        //     5: invokevirtual   net/minecraft/command/CommandResultStats$Type.func_179636_a:()I
        //     8: aaload         
        //     9: astore          lllllllllllllllllIIIIlllIIllIIll
        //    11: aload           lllllllllllllllllIIIIlllIIllIIll
        //    13: ifnull          100
        //    16: aload_1         /* lllllllllllllllllIIIIlllIIllIllI */
        //    17: aload           lllllllllllllllllIIIIlllIIllIIll
        //    19: invokestatic    net/minecraft/command/CommandBase.func_175758_e:(Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)Ljava/lang/String;
        //    22: astore          lllllllllllllllllIIIIlllIIllIIlI
        //    24: goto            30
        //    27: astore          lllllllllllllllllIIIIlllIIllIIII
        //    29: return         
        //    30: aload_0         /* lllllllllllllllllIIIIlllIIlIlIll */
        //    31: getfield        net/minecraft/command/CommandResultStats.field_179673_d:[Ljava/lang/String;
        //    34: aload_2         /* lllllllllllllllllIIIIlllIIlIlIIl */
        //    35: invokevirtual   net/minecraft/command/CommandResultStats$Type.func_179636_a:()I
        //    38: aaload         
        //    39: astore          lllllllllllllllllIIIIlllIIlIllll
        //    41: aload           lllllllllllllllllIIIIlllIIlIllll
        //    43: ifnull          100
        //    46: aload_1         /* lllllllllllllllllIIIIlllIIllIllI */
        //    47: invokeinterface net/minecraft/command/ICommandSender.getEntityWorld:()Lnet/minecraft/world/World;
        //    52: invokevirtual   net/minecraft/world/World.getScoreboard:()Lnet/minecraft/scoreboard/Scoreboard;
        //    55: astore          lllllllllllllllllIIIIlllIIlIlllI
        //    57: aload           lllllllllllllllllIIIIlllIIlIlllI
        //    59: aload           lllllllllllllllllIIIIlllIIlIllll
        //    61: invokevirtual   net/minecraft/scoreboard/Scoreboard.getObjective:(Ljava/lang/String;)Lnet/minecraft/scoreboard/ScoreObjective;
        //    64: astore          lllllllllllllllllIIIIlllIIlIllIl
        //    66: aload           lllllllllllllllllIIIIlllIIlIllIl
        //    68: ifnull          100
        //    71: aload           lllllllllllllllllIIIIlllIIlIlllI
        //    73: aload           lllllllllllllllllIIIIlllIIllIIIl
        //    75: aload           lllllllllllllllllIIIIlllIIlIllIl
        //    77: invokevirtual   net/minecraft/scoreboard/Scoreboard.func_178819_b:(Ljava/lang/String;Lnet/minecraft/scoreboard/ScoreObjective;)Z
        //    80: ifeq            100
        //    83: aload           lllllllllllllllllIIIIlllIIlIlllI
        //    85: aload           lllllllllllllllllIIIIlllIIllIIIl
        //    87: aload           lllllllllllllllllIIIIlllIIlIllIl
        //    89: invokevirtual   net/minecraft/scoreboard/Scoreboard.getValueFromObjective:(Ljava/lang/String;Lnet/minecraft/scoreboard/ScoreObjective;)Lnet/minecraft/scoreboard/Score;
        //    92: astore          lllllllllllllllllIIIIlllIIlIllII
        //    94: aload           lllllllllllllllllIIIIlllIIlIllII
        //    96: iload_3         /* lllllllllllllllllIIIIlllIIlIlIII */
        //    97: invokevirtual   net/minecraft/scoreboard/Score.setScorePoints:(I)V
        //   100: return         
        //    StackMapTable: 00 03 FF 00 1B 00 05 07 00 02 07 00 D1 07 00 06 01 07 00 5A 00 01 07 00 C9 FC 00 02 07 00 5A FA 00 45
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                           
        //  -----  -----  -----  -----  -----------------------------------------------
        //  16     24     27     30     Lnet/minecraft/command/EntityNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public enum Type
    {
        AFFECTED_ENTITIES("AFFECTED_ENTITIES", 2, "AFFECTED_ENTITIES", 2, 2, "AffectedEntities");
        
        final /* synthetic */ String field_179640_g;
        final /* synthetic */ int field_179639_f;
        
        SUCCESS_COUNT("SUCCESS_COUNT", 0, "SUCCESS_COUNT", 0, 0, "SuccessCount"), 
        AFFECTED_BLOCKS("AFFECTED_BLOCKS", 1, "AFFECTED_BLOCKS", 1, 1, "AffectedBlocks"), 
        QUERY_RESULT("QUERY_RESULT", 4, "QUERY_RESULT", 4, 4, "QueryResult"), 
        AFFECTED_ITEMS("AFFECTED_ITEMS", 3, "AFFECTED_ITEMS", 3, 3, "AffectedItems");
        
        public int func_179636_a() {
            return this.field_179639_f;
        }
        
        private Type(final String llllllllllllllIllIIIllllIllIIllI, final int llllllllllllllIllIIIllllIllIIlIl, final String llllllllllllllIllIIIllllIllIlIll, final int llllllllllllllIllIIIllllIllIlIlI, final int llllllllllllllIllIIIllllIllIlIIl, final String llllllllllllllIllIIIllllIllIlIII) {
            this.field_179639_f = llllllllllllllIllIIIllllIllIlIIl;
            this.field_179640_g = llllllllllllllIllIIIllllIllIlIII;
        }
        
        public static String[] func_179634_c() {
            final String[] llllllllllllllIllIIIllllIlIlIllI = new String[values().length];
            int llllllllllllllIllIIIllllIlIlIlIl = 0;
            for (final Type llllllllllllllIllIIIllllIlIlIIIl : values()) {
                llllllllllllllIllIIIllllIlIlIllI[llllllllllllllIllIIIllllIlIlIlIl++] = llllllllllllllIllIIIllllIlIlIIIl.func_179637_b();
            }
            return llllllllllllllIllIIIllllIlIlIllI;
        }
        
        public String func_179637_b() {
            return this.field_179640_g;
        }
        
        public static Type func_179635_a(final String llllllllllllllIllIIIllllIlIIIlIl) {
            for (final Type llllllllllllllIllIIIllllIlIIIIIl : values()) {
                if (llllllllllllllIllIIIllllIlIIIIIl.func_179637_b().equals(llllllllllllllIllIIIllllIlIIIlIl)) {
                    return llllllllllllllIllIIIllllIlIIIIIl;
                }
            }
            return null;
        }
        
        static {
            __OBFID = "CL_00002363";
        }
    }
}
