package net.minecraft.world;

import net.minecraft.nbt.*;
import java.util.*;

public class GameRules
{
    private /* synthetic */ TreeMap theGameRules;
    
    public boolean hasRule(final String llllllllllllllIlllIIlIllIllIIIlI) {
        return this.theGameRules.containsKey(llllllllllllllIlllIIlIllIllIIIlI);
    }
    
    public String[] getRules() {
        return (String[])this.theGameRules.keySet().toArray(new String[0]);
    }
    
    public void readGameRulesFromNBT(final NBTTagCompound llllllllllllllIlllIIlIllIlllIlIl) {
        final Set llllllllllllllIlllIIlIllIlllIlII = llllllllllllllIlllIIlIllIlllIlIl.getKeySet();
        for (final String llllllllllllllIlllIIlIllIlllIIlI : llllllllllllllIlllIIlIllIlllIlII) {
            final String llllllllllllllIlllIIlIllIlllIIIl = llllllllllllllIlllIIlIllIlllIlIl.getString(llllllllllllllIlllIIlIllIlllIIlI);
            this.setOrCreateGameRule(llllllllllllllIlllIIlIllIlllIIlI, llllllllllllllIlllIIlIllIlllIIIl);
        }
    }
    
    public String getGameRuleStringValue(final String llllllllllllllIlllIIlIlllIIlllll) {
        final Value llllllllllllllIlllIIlIlllIlIIIIl = this.theGameRules.get(llllllllllllllIlllIIlIlllIIlllll);
        return (llllllllllllllIlllIIlIlllIlIIIIl != null) ? llllllllllllllIlllIIlIlllIlIIIIl.getGameRuleStringValue() : "";
    }
    
    public GameRules() {
        this.theGameRules = new TreeMap();
        this.addGameRule("doFireTick", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("mobGriefing", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("keepInventory", "false", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doMobSpawning", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doMobLoot", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doTileDrops", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("commandBlockOutput", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("naturalRegeneration", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doDaylightCycle", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("logAdminCommands", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("showDeathMessages", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("randomTickSpeed", "3", ValueType.NUMERICAL_VALUE);
        this.addGameRule("sendCommandFeedback", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("reducedDebugInfo", "false", ValueType.BOOLEAN_VALUE);
    }
    
    public NBTTagCompound writeGameRulesToNBT() {
        final NBTTagCompound llllllllllllllIlllIIlIlllIIIIlIl = new NBTTagCompound();
        for (final String llllllllllllllIlllIIlIlllIIIIIll : this.theGameRules.keySet()) {
            final Value llllllllllllllIlllIIlIlllIIIIIlI = this.theGameRules.get(llllllllllllllIlllIIlIlllIIIIIll);
            llllllllllllllIlllIIlIlllIIIIlIl.setString(llllllllllllllIlllIIlIlllIIIIIll, llllllllllllllIlllIIlIlllIIIIIlI.getGameRuleStringValue());
        }
        return llllllllllllllIlllIIlIlllIIIIlIl;
    }
    
    public boolean areSameType(final String llllllllllllllIlllIIlIllIlIlllII, final ValueType llllllllllllllIlllIIlIllIlIllIll) {
        final Value llllllllllllllIlllIIlIllIlIllIlI = this.theGameRules.get(llllllllllllllIlllIIlIllIlIlllII);
        return llllllllllllllIlllIIlIllIlIllIlI != null && (llllllllllllllIlllIIlIllIlIllIlI.getType() == llllllllllllllIlllIIlIllIlIllIll || llllllllllllllIlllIIlIllIlIllIll == ValueType.ANY_VALUE);
    }
    
    public int getInt(final String llllllllllllllIlllIIlIlllIIlIIII) {
        final Value llllllllllllllIlllIIlIlllIIIllll = this.theGameRules.get(llllllllllllllIlllIIlIlllIIlIIII);
        return (llllllllllllllIlllIIlIlllIIIllll != null) ? llllllllllllllIlllIIlIlllIIIllll.getInt() : 0;
    }
    
    public boolean getGameRuleBooleanValue(final String llllllllllllllIlllIIlIlllIIlIllI) {
        final Value llllllllllllllIlllIIlIlllIIllIII = this.theGameRules.get(llllllllllllllIlllIIlIlllIIlIllI);
        return llllllllllllllIlllIIlIlllIIllIII != null && llllllllllllllIlllIIlIlllIIllIII.getGameRuleBooleanValue();
    }
    
    public void setOrCreateGameRule(final String llllllllllllllIlllIIlIlllIlIllIl, final String llllllllllllllIlllIIlIlllIlIllII) {
        final Value llllllllllllllIlllIIlIlllIlIlIll = this.theGameRules.get(llllllllllllllIlllIIlIlllIlIllIl);
        if (llllllllllllllIlllIIlIlllIlIlIll != null) {
            llllllllllllllIlllIIlIlllIlIlIll.setValue(llllllllllllllIlllIIlIlllIlIllII);
        }
        else {
            this.addGameRule(llllllllllllllIlllIIlIlllIlIllIl, llllllllllllllIlllIIlIlllIlIllII, ValueType.ANY_VALUE);
        }
    }
    
    public void addGameRule(final String llllllllllllllIlllIIlIlllIlllIIl, final String llllllllllllllIlllIIlIlllIllIlII, final ValueType llllllllllllllIlllIIlIlllIllIlll) {
        this.theGameRules.put(llllllllllllllIlllIIlIlllIlllIIl, new Value(llllllllllllllIlllIIlIlllIllIlII, llllllllllllllIlllIIlIlllIllIlll));
    }
    
    static class Value
    {
        private /* synthetic */ double valueDouble;
        private /* synthetic */ String valueString;
        private final /* synthetic */ ValueType type;
        private /* synthetic */ int valueInteger;
        private /* synthetic */ boolean valueBoolean;
        
        public String getGameRuleStringValue() {
            return this.valueString;
        }
        
        public boolean getGameRuleBooleanValue() {
            return this.valueBoolean;
        }
        
        public Value(final String llllllllllllllIllllIIIIlIlllIIll, final ValueType llllllllllllllIllllIIIIlIlllIlIl) {
            this.type = llllllllllllllIllllIIIIlIlllIlIl;
            this.setValue(llllllllllllllIllllIIIIlIlllIIll);
        }
        
        public int getInt() {
            return this.valueInteger;
        }
        
        public ValueType getType() {
            return this.type;
        }
        
        static {
            __OBFID = "CL_00000137";
        }
        
        public void setValue(final String llllllllllllllIllllIIIIlIllIlIll) {
            this.valueString = llllllllllllllIllllIIIIlIllIlIll;
            if (llllllllllllllIllllIIIIlIllIlIll != null) {
                if (llllllllllllllIllllIIIIlIllIlIll.equals("false")) {
                    this.valueBoolean = false;
                    return;
                }
                if (llllllllllllllIllllIIIIlIllIlIll.equals("true")) {
                    this.valueBoolean = true;
                    return;
                }
            }
            this.valueBoolean = Boolean.parseBoolean(llllllllllllllIllllIIIIlIllIlIll);
            this.valueInteger = (this.valueBoolean ? 1 : 0);
            try {
                this.valueInteger = Integer.parseInt(llllllllllllllIllllIIIIlIllIlIll);
            }
            catch (NumberFormatException ex) {}
            try {
                this.valueDouble = Double.parseDouble(llllllllllllllIllllIIIIlIllIlIll);
            }
            catch (NumberFormatException ex2) {}
        }
    }
    
    public enum ValueType
    {
        ANY_VALUE("ANY_VALUE", 0, "ANY_VALUE", 0, "ANY_VALUE", 0), 
        NUMERICAL_VALUE("NUMERICAL_VALUE", 2, "NUMERICAL_VALUE", 2, "NUMERICAL_VALUE", 2), 
        BOOLEAN_VALUE("BOOLEAN_VALUE", 1, "BOOLEAN_VALUE", 1, "BOOLEAN_VALUE", 1);
        
        private ValueType(final String lIIllllllIlIIlI, final int lIIllllllIlIIIl, final String lIIllllllIlIlll, final int lIIllllllIlIllI, final String lIIllllllIlIlIl, final int lIIllllllIlIlII) {
        }
    }
}
