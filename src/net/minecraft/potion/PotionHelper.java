package net.minecraft.potion;

import optifine.*;
import java.util.*;
import com.google.common.collect.*;

public class PotionHelper
{
    private static final /* synthetic */ Map field_179540_p;
    private static final /* synthetic */ Map field_179539_o;
    private static final /* synthetic */ String[] potionPrefixes;
    private static final /* synthetic */ Map field_77925_n;
    
    public static boolean checkFlag(final int llllllllllllllIIIlIlllIIIlIllllI, final int llllllllllllllIIIlIlllIIIlIlllll) {
        return (llllllllllllllIIIlIlllIIIlIllllI & 1 << llllllllllllllIIIlIlllIIIlIlllll) != 0x0;
    }
    
    private static int countSetFlags(int llllllllllllllIIIlIllIlllllllIll) {
        int llllllllllllllIIIlIllIllllllllII;
        for (llllllllllllllIIIlIllIllllllllII = 0; llllllllllllllIIIlIllIlllllllIll > 0; llllllllllllllIIIlIllIlllllllIll &= llllllllllllllIIIlIllIlllllllIll - 1, ++llllllllllllllIIIlIllIllllllllII) {}
        return llllllllllllllIIIlIllIllllllllII;
    }
    
    public static int func_77908_a(final int llllllllllllllIIIlIllIllIllIIIII, final int llllllllllllllIIIlIllIllIlIlllll, final int llllllllllllllIIIlIllIllIlIllllI, final int llllllllllllllIIIlIllIllIllIIIll, final int llllllllllllllIIIlIllIllIlIlllII, final int llllllllllllllIIIlIllIllIlIllIll) {
        return (checkFlag(llllllllllllllIIIlIllIllIllIIIII, llllllllllllllIIIlIllIllIlIlllll) ? 16 : 0) | (checkFlag(llllllllllllllIIIlIllIllIllIIIII, llllllllllllllIIIlIllIllIlIllllI) ? 8 : 0) | (checkFlag(llllllllllllllIIIlIllIllIllIIIII, llllllllllllllIIIlIllIllIllIIIll) ? 4 : 0) | (checkFlag(llllllllllllllIIIlIllIllIllIIIII, llllllllllllllIIIlIllIllIlIlllII) ? 2 : 0) | (checkFlag(llllllllllllllIIIlIllIllIllIIIII, llllllllllllllIIIlIllIllIlIllIll) ? 1 : 0);
    }
    
    public static int applyIngredient(int llllllllllllllIIIlIllIllIlllIlll, final String llllllllllllllIIIlIllIllIlllIllI) {
        final byte llllllllllllllIIIlIllIlllIIIIIII = 0;
        final int llllllllllllllIIIlIllIllIlllllll = llllllllllllllIIIlIllIllIlllIllI.length();
        boolean llllllllllllllIIIlIllIllIllllllI = false;
        boolean llllllllllllllIIIlIllIllIlllllIl = false;
        boolean llllllllllllllIIIlIllIllIlllllII = false;
        boolean llllllllllllllIIIlIllIllIllllIll = false;
        int llllllllllllllIIIlIllIllIllllIlI = 0;
        for (int llllllllllllllIIIlIllIllIllllIIl = llllllllllllllIIIlIllIlllIIIIIII; llllllllllllllIIIlIllIllIllllIIl < llllllllllllllIIIlIllIllIlllllll; ++llllllllllllllIIIlIllIllIllllIIl) {
            final char llllllllllllllIIIlIllIllIllllIII = llllllllllllllIIIlIllIllIlllIllI.charAt(llllllllllllllIIIlIllIllIllllIIl);
            if (llllllllllllllIIIlIllIllIllllIII >= '0' && llllllllllllllIIIlIllIllIllllIII <= '9') {
                llllllllllllllIIIlIllIllIllllIlI *= 10;
                llllllllllllllIIIlIllIllIllllIlI += llllllllllllllIIIlIllIllIllllIII - '0';
                llllllllllllllIIIlIllIllIllllllI = true;
            }
            else if (llllllllllllllIIIlIllIllIllllIII == '!') {
                if (llllllllllllllIIIlIllIllIllllllI) {
                    llllllllllllllIIIlIllIllIlllIlll = brewBitOperations(llllllllllllllIIIlIllIllIlllIlll, llllllllllllllIIIlIllIllIllllIlI, llllllllllllllIIIlIllIllIlllllII, llllllllllllllIIIlIllIllIlllllIl, llllllllllllllIIIlIllIllIllllIll);
                    llllllllllllllIIIlIllIllIllllIll = false;
                    llllllllllllllIIIlIllIllIlllllIl = false;
                    llllllllllllllIIIlIllIllIlllllII = false;
                    llllllllllllllIIIlIllIllIllllllI = false;
                    llllllllllllllIIIlIllIllIllllIlI = 0;
                }
                llllllllllllllIIIlIllIllIlllllIl = true;
            }
            else if (llllllllllllllIIIlIllIllIllllIII == '-') {
                if (llllllllllllllIIIlIllIllIllllllI) {
                    llllllllllllllIIIlIllIllIlllIlll = brewBitOperations(llllllllllllllIIIlIllIllIlllIlll, llllllllllllllIIIlIllIllIllllIlI, llllllllllllllIIIlIllIllIlllllII, llllllllllllllIIIlIllIllIlllllIl, llllllllllllllIIIlIllIllIllllIll);
                    llllllllllllllIIIlIllIllIllllIll = false;
                    llllllllllllllIIIlIllIllIlllllIl = false;
                    llllllllllllllIIIlIllIllIlllllII = false;
                    llllllllllllllIIIlIllIllIllllllI = false;
                    llllllllllllllIIIlIllIllIllllIlI = 0;
                }
                llllllllllllllIIIlIllIllIlllllII = true;
            }
            else if (llllllllllllllIIIlIllIllIllllIII == '+') {
                if (llllllllllllllIIIlIllIllIllllllI) {
                    llllllllllllllIIIlIllIllIlllIlll = brewBitOperations(llllllllllllllIIIlIllIllIlllIlll, llllllllllllllIIIlIllIllIllllIlI, llllllllllllllIIIlIllIllIlllllII, llllllllllllllIIIlIllIllIlllllIl, llllllllllllllIIIlIllIllIllllIll);
                    llllllllllllllIIIlIllIllIllllIll = false;
                    llllllllllllllIIIlIllIllIlllllIl = false;
                    llllllllllllllIIIlIllIllIlllllII = false;
                    llllllllllllllIIIlIllIllIllllllI = false;
                    llllllllllllllIIIlIllIllIllllIlI = 0;
                }
            }
            else if (llllllllllllllIIIlIllIllIllllIII == '&') {
                if (llllllllllllllIIIlIllIllIllllllI) {
                    llllllllllllllIIIlIllIllIlllIlll = brewBitOperations(llllllllllllllIIIlIllIllIlllIlll, llllllllllllllIIIlIllIllIllllIlI, llllllllllllllIIIlIllIllIlllllII, llllllllllllllIIIlIllIllIlllllIl, llllllllllllllIIIlIllIllIllllIll);
                    llllllllllllllIIIlIllIllIllllIll = false;
                    llllllllllllllIIIlIllIllIlllllIl = false;
                    llllllllllllllIIIlIllIllIlllllII = false;
                    llllllllllllllIIIlIllIllIllllllI = false;
                    llllllllllllllIIIlIllIllIllllIlI = 0;
                }
                llllllllllllllIIIlIllIllIllllIll = true;
            }
        }
        if (llllllllllllllIIIlIllIllIllllllI) {
            llllllllllllllIIIlIllIllIlllIlll = brewBitOperations(llllllllllllllIIIlIllIllIlllIlll, llllllllllllllIIIlIllIllIllllIlI, llllllllllllllIIIlIllIllIlllllII, llllllllllllllIIIlIllIllIlllllIl, llllllllllllllIIIlIllIllIllllIll);
        }
        return llllllllllllllIIIlIllIllIlllIlll & 0x7FFF;
    }
    
    public static int calcPotionLiquidColor(final Collection llllllllllllllIIIlIlllIIIlIIIIll) {
        int llllllllllllllIIIlIlllIIIlIIIIlI = 3694022;
        if (llllllllllllllIIIlIlllIIIlIIIIll == null || llllllllllllllIIIlIlllIIIlIIIIll.isEmpty()) {
            if (Config.isCustomColors()) {
                llllllllllllllIIIlIlllIIIlIIIIlI = CustomColors.getPotionColor(0, llllllllllllllIIIlIlllIIIlIIIIlI);
            }
            return llllllllllllllIIIlIlllIIIlIIIIlI;
        }
        float llllllllllllllIIIlIlllIIIlIIIIIl = 0.0f;
        float llllllllllllllIIIlIlllIIIlIIIIII = 0.0f;
        float llllllllllllllIIIlIlllIIIIllllll = 0.0f;
        float llllllllllllllIIIlIlllIIIIlllllI = 0.0f;
        for (final PotionEffect llllllllllllllIIIlIlllIIIIllllII : llllllllllllllIIIlIlllIIIlIIIIll) {
            if (llllllllllllllIIIlIlllIIIIllllII.func_180154_f()) {
                int llllllllllllllIIIlIlllIIIIlllIll = Potion.potionTypes[llllllllllllllIIIlIlllIIIIllllII.getPotionID()].getLiquidColor();
                if (Config.isCustomColors()) {
                    llllllllllllllIIIlIlllIIIIlllIll = CustomColors.getPotionColor(llllllllllllllIIIlIlllIIIIllllII.getPotionID(), llllllllllllllIIIlIlllIIIIlllIll);
                }
                for (int llllllllllllllIIIlIlllIIIIlllIlI = 0; llllllllllllllIIIlIlllIIIIlllIlI <= llllllllllllllIIIlIlllIIIIllllII.getAmplifier(); ++llllllllllllllIIIlIlllIIIIlllIlI) {
                    llllllllllllllIIIlIlllIIIlIIIIIl += (llllllllllllllIIIlIlllIIIIlllIll >> 16 & 0xFF) / 255.0f;
                    llllllllllllllIIIlIlllIIIlIIIIII += (llllllllllllllIIIlIlllIIIIlllIll >> 8 & 0xFF) / 255.0f;
                    llllllllllllllIIIlIlllIIIIllllll += (llllllllllllllIIIlIlllIIIIlllIll >> 0 & 0xFF) / 255.0f;
                    ++llllllllllllllIIIlIlllIIIIlllllI;
                }
            }
        }
        if (llllllllllllllIIIlIlllIIIIlllllI == 0.0f) {
            return 0;
        }
        llllllllllllllIIIlIlllIIIlIIIIIl = llllllllllllllIIIlIlllIIIlIIIIIl / llllllllllllllIIIlIlllIIIIlllllI * 255.0f;
        llllllllllllllIIIlIlllIIIlIIIIII = llllllllllllllIIIlIlllIIIlIIIIII / llllllllllllllIIIlIlllIIIIlllllI * 255.0f;
        llllllllllllllIIIlIlllIIIIllllll = llllllllllllllIIIlIlllIIIIllllll / llllllllllllllIIIlIlllIIIIlllllI * 255.0f;
        return (int)llllllllllllllIIIlIlllIIIlIIIIIl << 16 | (int)llllllllllllllIIIlIlllIIIlIIIIII << 8 | (int)llllllllllllllIIIlIlllIIIIllllll;
    }
    
    public static boolean func_82817_b(final Collection llllllllllllllIIIlIlllIIIIlIlIIl) {
        for (final PotionEffect llllllllllllllIIIlIlllIIIIlIlIlI : llllllllllllllIIIlIlllIIIIlIlIIl) {
            if (!llllllllllllllIIIlIlllIIIIlIlIlI.getIsAmbient()) {
                return false;
            }
        }
        return true;
    }
    
    public static int func_77909_a(final int llllllllllllllIIIlIlllIIIlIIllll) {
        return func_77908_a(llllllllllllllIIIlIlllIIIlIIllll, 5, 4, 3, 2, 1);
    }
    
    public static List getPotionEffects(final int llllllllllllllIIIlIllIlllIlIlIII, final boolean llllllllllllllIIIlIllIlllIllIIll) {
        ArrayList llllllllllllllIIIlIllIlllIllIIlI = null;
        for (final Potion llllllllllllllIIIlIllIlllIlIlllI : Potion.potionTypes) {
            if (llllllllllllllIIIlIllIlllIlIlllI != null && (!llllllllllllllIIIlIllIlllIlIlllI.isUsable() || llllllllllllllIIIlIllIlllIllIIll)) {
                final String llllllllllllllIIIlIllIlllIlIllIl = PotionHelper.field_179539_o.get(llllllllllllllIIIlIllIlllIlIlllI.getId());
                if (llllllllllllllIIIlIllIlllIlIllIl != null) {
                    int llllllllllllllIIIlIllIlllIlIllII = parsePotionEffects(llllllllllllllIIIlIllIlllIlIllIl, 0, llllllllllllllIIIlIllIlllIlIllIl.length(), llllllllllllllIIIlIllIlllIlIlIII);
                    if (llllllllllllllIIIlIllIlllIlIllII > 0) {
                        int llllllllllllllIIIlIllIlllIlIlIll = 0;
                        final String llllllllllllllIIIlIllIlllIlIlIlI = PotionHelper.field_179540_p.get(llllllllllllllIIIlIllIlllIlIlllI.getId());
                        if (llllllllllllllIIIlIllIlllIlIlIlI != null) {
                            llllllllllllllIIIlIllIlllIlIlIll = parsePotionEffects(llllllllllllllIIIlIllIlllIlIlIlI, 0, llllllllllllllIIIlIllIlllIlIlIlI.length(), llllllllllllllIIIlIllIlllIlIlIII);
                            if (llllllllllllllIIIlIllIlllIlIlIll < 0) {
                                llllllllllllllIIIlIllIlllIlIlIll = 0;
                            }
                        }
                        if (llllllllllllllIIIlIllIlllIlIlllI.isInstant()) {
                            llllllllllllllIIIlIllIlllIlIllII = 1;
                        }
                        else {
                            llllllllllllllIIIlIllIlllIlIllII = 1200 * (llllllllllllllIIIlIllIlllIlIllII * 3 + (llllllllllllllIIIlIllIlllIlIllII - 1) * 2);
                            llllllllllllllIIIlIllIlllIlIllII >>= llllllllllllllIIIlIllIlllIlIlIll;
                            llllllllllllllIIIlIllIlllIlIllII = (int)Math.round(llllllllllllllIIIlIllIlllIlIllII * llllllllllllllIIIlIllIlllIlIlllI.getEffectiveness());
                            if ((llllllllllllllIIIlIllIlllIlIlIII & 0x4000) != 0x0) {
                                llllllllllllllIIIlIllIlllIlIllII = (int)Math.round(llllllllllllllIIIlIllIlllIlIllII * 0.75 + 0.5);
                            }
                        }
                        if (llllllllllllllIIIlIllIlllIllIIlI == null) {
                            llllllllllllllIIIlIllIlllIllIIlI = Lists.newArrayList();
                        }
                        final PotionEffect llllllllllllllIIIlIllIlllIlIlIIl = new PotionEffect(llllllllllllllIIIlIllIlllIlIlllI.getId(), llllllllllllllIIIlIllIlllIlIllII, llllllllllllllIIIlIllIlllIlIlIll);
                        if ((llllllllllllllIIIlIllIlllIlIlIII & 0x4000) != 0x0) {
                            llllllllllllllIIIlIllIlllIlIlIIl.setSplashPotion(true);
                        }
                        llllllllllllllIIIlIllIlllIllIIlI.add(llllllllllllllIIIlIllIlllIlIlIIl);
                    }
                }
            }
        }
        return llllllllllllllIIIlIllIlllIllIIlI;
    }
    
    public static int func_77915_a(final int llllllllllllllIIIlIlllIIIIlIIIII, final boolean llllllllllllllIIIlIlllIIIIIlllll) {
        if (llllllllllllllIIIlIlllIIIIIlllll) {
            return calcPotionLiquidColor(getPotionEffects(llllllllllllllIIIlIlllIIIIlIIIII, true));
        }
        if (PotionHelper.field_77925_n.containsKey(llllllllllllllIIIlIlllIIIIlIIIII)) {
            return PotionHelper.field_77925_n.get(llllllllllllllIIIlIlllIIIIlIIIII);
        }
        final int llllllllllllllIIIlIlllIIIIlIIIIl = calcPotionLiquidColor(getPotionEffects(llllllllllllllIIIlIlllIIIIlIIIII, false));
        PotionHelper.field_77925_n.put(llllllllllllllIIIlIlllIIIIlIIIII, llllllllllllllIIIlIlllIIIIlIIIIl);
        return llllllllllllllIIIlIlllIIIIlIIIIl;
    }
    
    private static int func_77904_a(final boolean llllllllllllllIIIlIlllIIIIIIllll, final boolean llllllllllllllIIIlIlllIIIIIIlllI, final boolean llllllllllllllIIIlIlllIIIIIIllIl, final int llllllllllllllIIIlIlllIIIIIIIlII, final int llllllllllllllIIIlIlllIIIIIIIIll, final int llllllllllllllIIIlIlllIIIIIIlIlI, final int llllllllllllllIIIlIlllIIIIIIlIIl) {
        int llllllllllllllIIIlIlllIIIIIIlIII = 0;
        if (llllllllllllllIIIlIlllIIIIIIllll) {
            llllllllllllllIIIlIlllIIIIIIlIII = isFlagUnset(llllllllllllllIIIlIlllIIIIIIlIIl, llllllllllllllIIIlIlllIIIIIIIIll);
        }
        else if (llllllllllllllIIIlIlllIIIIIIIlII != -1) {
            if (llllllllllllllIIIlIlllIIIIIIIlII == 0 && countSetFlags(llllllllllllllIIIlIlllIIIIIIlIIl) == llllllllllllllIIIlIlllIIIIIIIIll) {
                llllllllllllllIIIlIlllIIIIIIlIII = 1;
            }
            else if (llllllllllllllIIIlIlllIIIIIIIlII == 1 && countSetFlags(llllllllllllllIIIlIlllIIIIIIlIIl) > llllllllllllllIIIlIlllIIIIIIIIll) {
                llllllllllllllIIIlIlllIIIIIIlIII = 1;
            }
            else if (llllllllllllllIIIlIlllIIIIIIIlII == 2 && countSetFlags(llllllllllllllIIIlIlllIIIIIIlIIl) < llllllllllllllIIIlIlllIIIIIIIIll) {
                llllllllllllllIIIlIlllIIIIIIlIII = 1;
            }
        }
        else {
            llllllllllllllIIIlIlllIIIIIIlIII = isFlagSet(llllllllllllllIIIlIlllIIIIIIlIIl, llllllllllllllIIIlIlllIIIIIIIIll);
        }
        if (llllllllllllllIIIlIlllIIIIIIlllI) {
            llllllllllllllIIIlIlllIIIIIIlIII *= llllllllllllllIIIlIlllIIIIIIlIlI;
        }
        if (llllllllllllllIIIlIlllIIIIIIllIl) {
            llllllllllllllIIIlIlllIIIIIIlIII *= -1;
        }
        return llllllllllllllIIIlIlllIIIIIIlIII;
    }
    
    private static int parsePotionEffects(final String llllllllllllllIIIlIllIllllIlIIlI, final int llllllllllllllIIIlIllIllllIlIIIl, final int llllllllllllllIIIlIllIlllllIIlIl, final int llllllllllllllIIIlIllIllllIIllll) {
        if (llllllllllllllIIIlIllIllllIlIIIl >= llllllllllllllIIIlIllIllllIlIIlI.length() || llllllllllllllIIIlIllIlllllIIlIl < 0 || llllllllllllllIIIlIllIllllIlIIIl >= llllllllllllllIIIlIllIlllllIIlIl) {
            return 0;
        }
        final int llllllllllllllIIIlIllIlllllIIIll = llllllllllllllIIIlIllIllllIlIIlI.indexOf(124, llllllllllllllIIIlIllIllllIlIIIl);
        if (llllllllllllllIIIlIllIlllllIIIll >= 0 && llllllllllllllIIIlIllIlllllIIIll < llllllllllllllIIIlIllIlllllIIlIl) {
            final int llllllllllllllIIIlIllIlllllIIIlI = parsePotionEffects(llllllllllllllIIIlIllIllllIlIIlI, llllllllllllllIIIlIllIllllIlIIIl, llllllllllllllIIIlIllIlllllIIIll - 1, llllllllllllllIIIlIllIllllIIllll);
            if (llllllllllllllIIIlIllIlllllIIIlI > 0) {
                return llllllllllllllIIIlIllIlllllIIIlI;
            }
            final int llllllllllllllIIIlIllIlllllIIIII = parsePotionEffects(llllllllllllllIIIlIllIllllIlIIlI, llllllllllllllIIIlIllIlllllIIIll + 1, llllllllllllllIIIlIllIlllllIIlIl, llllllllllllllIIIlIllIllllIIllll);
            return (llllllllllllllIIIlIllIlllllIIIII > 0) ? llllllllllllllIIIlIllIlllllIIIII : 0;
        }
        else {
            final int llllllllllllllIIIlIllIlllllIIIIl = llllllllllllllIIIlIllIllllIlIIlI.indexOf(38, llllllllllllllIIIlIllIllllIlIIIl);
            if (llllllllllllllIIIlIllIlllllIIIIl < 0 || llllllllllllllIIIlIllIlllllIIIIl >= llllllllllllllIIIlIllIlllllIIlIl) {
                boolean llllllllllllllIIIlIllIllllIlllIl = false;
                boolean llllllllllllllIIIlIllIllllIlllII = false;
                boolean llllllllllllllIIIlIllIllllIllIll = false;
                boolean llllllllllllllIIIlIllIllllIllIlI = false;
                boolean llllllllllllllIIIlIllIllllIllIIl = false;
                byte llllllllllllllIIIlIllIllllIllIII = -1;
                int llllllllllllllIIIlIllIllllIlIlll = 0;
                int llllllllllllllIIIlIllIllllIlIllI = 0;
                int llllllllllllllIIIlIllIllllIlIlIl = 0;
                for (int llllllllllllllIIIlIllIllllIlIlII = llllllllllllllIIIlIllIllllIlIIIl; llllllllllllllIIIlIllIllllIlIlII < llllllllllllllIIIlIllIlllllIIlIl; ++llllllllllllllIIIlIllIllllIlIlII) {
                    final char llllllllllllllIIIlIllIllllIlIIll = llllllllllllllIIIlIllIllllIlIIlI.charAt(llllllllllllllIIIlIllIllllIlIlII);
                    if (llllllllllllllIIIlIllIllllIlIIll >= '0' && llllllllllllllIIIlIllIllllIlIIll <= '9') {
                        if (llllllllllllllIIIlIllIllllIlllIl) {
                            llllllllllllllIIIlIllIllllIlIllI = llllllllllllllIIIlIllIllllIlIIll - '0';
                            llllllllllllllIIIlIllIllllIlllII = true;
                        }
                        else {
                            llllllllllllllIIIlIllIllllIlIlll *= 10;
                            llllllllllllllIIIlIllIllllIlIlll += llllllllllllllIIIlIllIllllIlIIll - '0';
                            llllllllllllllIIIlIllIllllIllIll = true;
                        }
                    }
                    else if (llllllllllllllIIIlIllIllllIlIIll == '*') {
                        llllllllllllllIIIlIllIllllIlllIl = true;
                    }
                    else if (llllllllllllllIIIlIllIllllIlIIll == '!') {
                        if (llllllllllllllIIIlIllIllllIllIll) {
                            llllllllllllllIIIlIllIllllIlIlIl += func_77904_a(llllllllllllllIIIlIllIllllIllIlI, llllllllllllllIIIlIllIllllIlllII, llllllllllllllIIIlIllIllllIllIIl, llllllllllllllIIIlIllIllllIllIII, llllllllllllllIIIlIllIllllIlIlll, llllllllllllllIIIlIllIllllIlIllI, llllllllllllllIIIlIllIllllIIllll);
                            llllllllllllllIIIlIllIllllIllIlI = false;
                            llllllllllllllIIIlIllIllllIllIIl = false;
                            llllllllllllllIIIlIllIllllIlllIl = false;
                            llllllllllllllIIIlIllIllllIlllII = false;
                            llllllllllllllIIIlIllIllllIllIll = false;
                            llllllllllllllIIIlIllIllllIlIllI = 0;
                            llllllllllllllIIIlIllIllllIlIlll = 0;
                            llllllllllllllIIIlIllIllllIllIII = -1;
                        }
                        llllllllllllllIIIlIllIllllIllIlI = true;
                    }
                    else if (llllllllllllllIIIlIllIllllIlIIll == '-') {
                        if (llllllllllllllIIIlIllIllllIllIll) {
                            llllllllllllllIIIlIllIllllIlIlIl += func_77904_a(llllllllllllllIIIlIllIllllIllIlI, llllllllllllllIIIlIllIllllIlllII, llllllllllllllIIIlIllIllllIllIIl, llllllllllllllIIIlIllIllllIllIII, llllllllllllllIIIlIllIllllIlIlll, llllllllllllllIIIlIllIllllIlIllI, llllllllllllllIIIlIllIllllIIllll);
                            llllllllllllllIIIlIllIllllIllIlI = false;
                            llllllllllllllIIIlIllIllllIllIIl = false;
                            llllllllllllllIIIlIllIllllIlllIl = false;
                            llllllllllllllIIIlIllIllllIlllII = false;
                            llllllllllllllIIIlIllIllllIllIll = false;
                            llllllllllllllIIIlIllIllllIlIllI = 0;
                            llllllllllllllIIIlIllIllllIlIlll = 0;
                            llllllllllllllIIIlIllIllllIllIII = -1;
                        }
                        llllllllllllllIIIlIllIllllIllIIl = true;
                    }
                    else if (llllllllllllllIIIlIllIllllIlIIll != '=' && llllllllllllllIIIlIllIllllIlIIll != '<' && llllllllllllllIIIlIllIllllIlIIll != '>') {
                        if (llllllllllllllIIIlIllIllllIlIIll == '+' && llllllllllllllIIIlIllIllllIllIll) {
                            llllllllllllllIIIlIllIllllIlIlIl += func_77904_a(llllllllllllllIIIlIllIllllIllIlI, llllllllllllllIIIlIllIllllIlllII, llllllllllllllIIIlIllIllllIllIIl, llllllllllllllIIIlIllIllllIllIII, llllllllllllllIIIlIllIllllIlIlll, llllllllllllllIIIlIllIllllIlIllI, llllllllllllllIIIlIllIllllIIllll);
                            llllllllllllllIIIlIllIllllIllIlI = false;
                            llllllllllllllIIIlIllIllllIllIIl = false;
                            llllllllllllllIIIlIllIllllIlllIl = false;
                            llllllllllllllIIIlIllIllllIlllII = false;
                            llllllllllllllIIIlIllIllllIllIll = false;
                            llllllllllllllIIIlIllIllllIlIllI = 0;
                            llllllllllllllIIIlIllIllllIlIlll = 0;
                            llllllllllllllIIIlIllIllllIllIII = -1;
                        }
                    }
                    else {
                        if (llllllllllllllIIIlIllIllllIllIll) {
                            llllllllllllllIIIlIllIllllIlIlIl += func_77904_a(llllllllllllllIIIlIllIllllIllIlI, llllllllllllllIIIlIllIllllIlllII, llllllllllllllIIIlIllIllllIllIIl, llllllllllllllIIIlIllIllllIllIII, llllllllllllllIIIlIllIllllIlIlll, llllllllllllllIIIlIllIllllIlIllI, llllllllllllllIIIlIllIllllIIllll);
                            llllllllllllllIIIlIllIllllIllIlI = false;
                            llllllllllllllIIIlIllIllllIllIIl = false;
                            llllllllllllllIIIlIllIllllIlllIl = false;
                            llllllllllllllIIIlIllIllllIlllII = false;
                            llllllllllllllIIIlIllIllllIllIll = false;
                            llllllllllllllIIIlIllIllllIlIllI = 0;
                            llllllllllllllIIIlIllIllllIlIlll = 0;
                            llllllllllllllIIIlIllIllllIllIII = -1;
                        }
                        if (llllllllllllllIIIlIllIllllIlIIll == '=') {
                            llllllllllllllIIIlIllIllllIllIII = 0;
                        }
                        else if (llllllllllllllIIIlIllIllllIlIIll == '<') {
                            llllllllllllllIIIlIllIllllIllIII = 2;
                        }
                        else if (llllllllllllllIIIlIllIllllIlIIll == '>') {
                            llllllllllllllIIIlIllIllllIllIII = 1;
                        }
                    }
                }
                if (llllllllllllllIIIlIllIllllIllIll) {
                    llllllllllllllIIIlIllIllllIlIlIl += func_77904_a(llllllllllllllIIIlIllIllllIllIlI, llllllllllllllIIIlIllIllllIlllII, llllllllllllllIIIlIllIllllIllIIl, llllllllllllllIIIlIllIllllIllIII, llllllllllllllIIIlIllIllllIlIlll, llllllllllllllIIIlIllIllllIlIllI, llllllllllllllIIIlIllIllllIIllll);
                }
                return llllllllllllllIIIlIllIllllIlIlIl;
            }
            final int llllllllllllllIIIlIllIllllIlllll = parsePotionEffects(llllllllllllllIIIlIllIllllIlIIlI, llllllllllllllIIIlIllIllllIlIIIl, llllllllllllllIIIlIllIlllllIIIIl - 1, llllllllllllllIIIlIllIllllIIllll);
            if (llllllllllllllIIIlIllIllllIlllll <= 0) {
                return 0;
            }
            final int llllllllllllllIIIlIllIllllIllllI = parsePotionEffects(llllllllllllllIIIlIllIllllIlIIlI, llllllllllllllIIIlIllIlllllIIIIl + 1, llllllllllllllIIIlIllIlllllIIlIl, llllllllllllllIIIlIllIllllIIllll);
            return (llllllllllllllIIIlIllIllllIllllI <= 0) ? 0 : ((llllllllllllllIIIlIllIllllIlllll > llllllllllllllIIIlIllIllllIllllI) ? llllllllllllllIIIlIllIllllIlllll : llllllllllllllIIIlIllIllllIllllI);
        }
    }
    
    private static int isFlagSet(final int llllllllllllllIIIlIlllIIIlIllIlI, final int llllllllllllllIIIlIlllIIIlIlIlll) {
        return checkFlag(llllllllllllllIIIlIlllIIIlIllIlI, llllllllllllllIIIlIlllIIIlIlIlll) ? 1 : 0;
    }
    
    private static int brewBitOperations(int llllllllllllllIIIlIllIlllIIlIIlI, final int llllllllllllllIIIlIllIlllIIlIIIl, final boolean llllllllllllllIIIlIllIlllIIlIIII, final boolean llllllllllllllIIIlIllIlllIIlIlII, final boolean llllllllllllllIIIlIllIlllIIIlllI) {
        if (llllllllllllllIIIlIllIlllIIIlllI) {
            if (!checkFlag((int)llllllllllllllIIIlIllIlllIIlIIlI, llllllllllllllIIIlIllIlllIIlIIIl)) {
                return 0;
            }
        }
        else if (llllllllllllllIIIlIllIlllIIlIIII) {
            llllllllllllllIIIlIllIlllIIlIIlI &= ~(1 << llllllllllllllIIIlIllIlllIIlIIIl);
        }
        else if (llllllllllllllIIIlIllIlllIIlIlII) {
            if ((llllllllllllllIIIlIllIlllIIlIIlI & 1 << llllllllllllllIIIlIllIlllIIlIIIl) == 0x0) {
                llllllllllllllIIIlIllIlllIIlIIlI |= 1 << llllllllllllllIIIlIllIlllIIlIIIl;
            }
            else {
                llllllllllllllIIIlIllIlllIIlIIlI &= ~(1 << llllllllllllllIIIlIllIlllIIlIIIl);
            }
        }
        else {
            llllllllllllllIIIlIllIlllIIlIIlI |= 1 << llllllllllllllIIIlIllIlllIIlIIIl;
        }
        return (int)llllllllllllllIIIlIllIlllIIlIIlI;
    }
    
    public static void clearPotionColorCache() {
        PotionHelper.field_77925_n.clear();
    }
    
    private static int isFlagUnset(final int llllllllllllllIIIlIlllIIIlIlIlII, final int llllllllllllllIIIlIlllIIIlIlIIll) {
        return checkFlag(llllllllllllllIIIlIlllIIIlIlIlII, llllllllllllllIIIlIlllIIIlIlIIll) ? 0 : 1;
    }
    
    static {
        ghastTearEffect = "+0-1-2-3&4-4+13";
        field_77924_a = null;
        field_179539_o = Maps.newHashMap();
        field_179540_p = Maps.newHashMap();
        PotionHelper.field_179539_o.put(Potion.regeneration.getId(), "0 & !1 & !2 & !3 & 0+6");
        sugarEffect = "-0+1-2-3&4-4+13";
        PotionHelper.field_179539_o.put(Potion.moveSpeed.getId(), "!0 & 1 & !2 & !3 & 1+6");
        magmaCreamEffect = "+0+1-2-3&4-4+13";
        PotionHelper.field_179539_o.put(Potion.fireResistance.getId(), "0 & 1 & !2 & !3 & 0+6");
        speckledMelonEffect = "+0-1+2-3&4-4+13";
        PotionHelper.field_179539_o.put(Potion.heal.getId(), "0 & !1 & 2 & !3");
        spiderEyeEffect = "-0-1+2-3&4-4+13";
        PotionHelper.field_179539_o.put(Potion.poison.getId(), "!0 & !1 & 2 & !3 & 2+6");
        fermentedSpiderEyeEffect = "-0+3-4+13";
        PotionHelper.field_179539_o.put(Potion.weakness.getId(), "!0 & !1 & !2 & 3 & 3+6");
        PotionHelper.field_179539_o.put(Potion.harm.getId(), "!0 & !1 & 2 & 3");
        PotionHelper.field_179539_o.put(Potion.moveSlowdown.getId(), "!0 & 1 & !2 & 3 & 3+6");
        blazePowderEffect = "+0-1-2+3&4-4+13";
        PotionHelper.field_179539_o.put(Potion.damageBoost.getId(), "0 & !1 & !2 & 3 & 3+6");
        goldenCarrotEffect = "-0+1+2-3+13&4-4";
        PotionHelper.field_179539_o.put(Potion.nightVision.getId(), "!0 & 1 & 2 & !3 & 2+6");
        PotionHelper.field_179539_o.put(Potion.invisibility.getId(), "!0 & 1 & 2 & 3 & 2+6");
        field_151423_m = "+0-1+2+3+13&4-4";
        PotionHelper.field_179539_o.put(Potion.waterBreathing.getId(), "0 & !1 & 2 & 3 & 2+6");
        field_179538_n = "+0+1-2+3&4-4+13";
        PotionHelper.field_179539_o.put(Potion.jump.getId(), "0 & 1 & !2 & 3");
        glowstoneEffect = "+5-6-7";
        PotionHelper.field_179540_p.put(Potion.moveSpeed.getId(), "5");
        PotionHelper.field_179540_p.put(Potion.digSpeed.getId(), "5");
        PotionHelper.field_179540_p.put(Potion.damageBoost.getId(), "5");
        PotionHelper.field_179540_p.put(Potion.regeneration.getId(), "5");
        PotionHelper.field_179540_p.put(Potion.harm.getId(), "5");
        PotionHelper.field_179540_p.put(Potion.heal.getId(), "5");
        PotionHelper.field_179540_p.put(Potion.resistance.getId(), "5");
        PotionHelper.field_179540_p.put(Potion.poison.getId(), "5");
        PotionHelper.field_179540_p.put(Potion.jump.getId(), "5");
        redstoneEffect = "-5+6-7";
        gunpowderEffect = "+14&13-13";
        field_77925_n = Maps.newHashMap();
        potionPrefixes = new String[] { "potion.prefix.mundane", "potion.prefix.uninteresting", "potion.prefix.bland", "potion.prefix.clear", "potion.prefix.milky", "potion.prefix.diffuse", "potion.prefix.artless", "potion.prefix.thin", "potion.prefix.awkward", "potion.prefix.flat", "potion.prefix.bulky", "potion.prefix.bungling", "potion.prefix.buttered", "potion.prefix.smooth", "potion.prefix.suave", "potion.prefix.debonair", "potion.prefix.thick", "potion.prefix.elegant", "potion.prefix.fancy", "potion.prefix.charming", "potion.prefix.dashing", "potion.prefix.refined", "potion.prefix.cordial", "potion.prefix.sparkling", "potion.prefix.potent", "potion.prefix.foul", "potion.prefix.odorless", "potion.prefix.rank", "potion.prefix.harsh", "potion.prefix.acrid", "potion.prefix.gross", "potion.prefix.stinky" };
    }
    
    public static String func_77905_c(final int llllllllllllllIIIlIlllIIIIIllIll) {
        final int llllllllllllllIIIlIlllIIIIIllIlI = func_77909_a(llllllllllllllIIIlIlllIIIIIllIll);
        return PotionHelper.potionPrefixes[llllllllllllllIIIlIlllIIIIIllIlI];
    }
}
