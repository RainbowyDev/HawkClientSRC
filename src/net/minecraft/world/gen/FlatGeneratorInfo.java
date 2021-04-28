package net.minecraft.world.gen;

import com.google.common.collect.*;
import net.minecraft.world.biome.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import java.util.*;

public class FlatGeneratorInfo
{
    private final /* synthetic */ Map worldFeatures;
    private /* synthetic */ int biomeToUse;
    private final /* synthetic */ List flatLayers;
    
    public void func_82645_d() {
        int llllllllllllllllIlIIlIIlllIlIlIl = 0;
        for (final FlatLayerInfo llllllllllllllllIlIIlIIlllIlIlII : this.flatLayers) {
            llllllllllllllllIlIIlIIlllIlIlII.setMinY(llllllllllllllllIlIIlIIlllIlIlIl);
            llllllllllllllllIlIIlIIlllIlIlIl += llllllllllllllllIlIIlIIlllIlIlII.getLayerCount();
        }
    }
    
    public FlatGeneratorInfo() {
        this.flatLayers = Lists.newArrayList();
        this.worldFeatures = Maps.newHashMap();
    }
    
    public static FlatGeneratorInfo getDefaultFlatGenerator() {
        final FlatGeneratorInfo llllllllllllllllIlIIlIIlIlIIIllI = new FlatGeneratorInfo();
        llllllllllllllllIlIIlIIlIlIIIllI.setBiome(BiomeGenBase.plains.biomeID);
        llllllllllllllllIlIIlIIlIlIIIllI.getFlatLayers().add(new FlatLayerInfo(1, Blocks.bedrock));
        llllllllllllllllIlIIlIIlIlIIIllI.getFlatLayers().add(new FlatLayerInfo(2, Blocks.dirt));
        llllllllllllllllIlIIlIIlIlIIIllI.getFlatLayers().add(new FlatLayerInfo(1, Blocks.grass));
        llllllllllllllllIlIIlIIlIlIIIllI.func_82645_d();
        llllllllllllllllIlIIlIIlIlIIIllI.getWorldFeatures().put("village", Maps.newHashMap());
        return llllllllllllllllIlIIlIIlIlIIIllI;
    }
    
    private static List func_180716_a(final int llllllllllllllllIlIIlIIllIIIIlII, final String llllllllllllllllIlIIlIIllIIIllIl) {
        if (llllllllllllllllIlIIlIIllIIIllIl != null && llllllllllllllllIlIIlIIllIIIllIl.length() >= 1) {
            final ArrayList llllllllllllllllIlIIlIIllIIIllII = Lists.newArrayList();
            final String[] llllllllllllllllIlIIlIIllIIIlIll = llllllllllllllllIlIIlIIllIIIllIl.split(",");
            int llllllllllllllllIlIIlIIllIIIlIlI = 0;
            final String[] llllllllllllllllIlIIlIIllIIIlIIl = llllllllllllllllIlIIlIIllIIIlIll;
            for (int llllllllllllllllIlIIlIIllIIIlIII = llllllllllllllllIlIIlIIllIIIlIll.length, llllllllllllllllIlIIlIIllIIIIlll = 0; llllllllllllllllIlIIlIIllIIIIlll < llllllllllllllllIlIIlIIllIIIlIII; ++llllllllllllllllIlIIlIIllIIIIlll) {
                final String llllllllllllllllIlIIlIIllIIIIllI = llllllllllllllllIlIIlIIllIIIlIIl[llllllllllllllllIlIIlIIllIIIIlll];
                final FlatLayerInfo llllllllllllllllIlIIlIIllIIIIlIl = func_180715_a(llllllllllllllllIlIIlIIllIIIIlII, llllllllllllllllIlIIlIIllIIIIllI, llllllllllllllllIlIIlIIllIIIlIlI);
                if (llllllllllllllllIlIIlIIllIIIIlIl == null) {
                    return null;
                }
                llllllllllllllllIlIIlIIllIIIllII.add(llllllllllllllllIlIIlIIllIIIIlIl);
                llllllllllllllllIlIIlIIllIIIlIlI += llllllllllllllllIlIIlIIllIIIIlIl.getLayerCount();
            }
            return llllllllllllllllIlIIlIIllIIIllII;
        }
        return null;
    }
    
    public void setBiome(final int llllllllllllllllIlIIlIIllllIIIll) {
        this.biomeToUse = llllllllllllllllIlIIlIIllllIIIll;
    }
    
    public List getFlatLayers() {
        return this.flatLayers;
    }
    
    static {
        __OBFID = "CL_00000440";
    }
    
    public static FlatGeneratorInfo createFlatGeneratorFromString(final String llllllllllllllllIlIIlIIlIllIlIIl) {
        if (llllllllllllllllIlIIlIIlIllIlIIl == null) {
            return getDefaultFlatGenerator();
        }
        final String[] llllllllllllllllIlIIlIIlIllIlIII = llllllllllllllllIlIIlIIlIllIlIIl.split(";", -1);
        final int llllllllllllllllIlIIlIIlIllIIlll = (llllllllllllllllIlIIlIIlIllIlIII.length == 1) ? 0 : MathHelper.parseIntWithDefault(llllllllllllllllIlIIlIIlIllIlIII[0], 0);
        if (llllllllllllllllIlIIlIIlIllIIlll < 0 || llllllllllllllllIlIIlIIlIllIIlll > 3) {
            return getDefaultFlatGenerator();
        }
        final FlatGeneratorInfo llllllllllllllllIlIIlIIlIllIIllI = new FlatGeneratorInfo();
        int llllllllllllllllIlIIlIIlIllIIlIl = (llllllllllllllllIlIIlIIlIllIlIII.length != 1) ? 1 : 0;
        final List llllllllllllllllIlIIlIIlIllIIlII = func_180716_a(llllllllllllllllIlIIlIIlIllIIlll, llllllllllllllllIlIIlIIlIllIlIII[llllllllllllllllIlIIlIIlIllIIlIl++]);
        if (llllllllllllllllIlIIlIIlIllIIlII != null && !llllllllllllllllIlIIlIIlIllIIlII.isEmpty()) {
            llllllllllllllllIlIIlIIlIllIIllI.getFlatLayers().addAll(llllllllllllllllIlIIlIIlIllIIlII);
            llllllllllllllllIlIIlIIlIllIIllI.func_82645_d();
            int llllllllllllllllIlIIlIIlIllIIIll = BiomeGenBase.plains.biomeID;
            if (llllllllllllllllIlIIlIIlIllIIlll > 0 && llllllllllllllllIlIIlIIlIllIlIII.length > llllllllllllllllIlIIlIIlIllIIlIl) {
                llllllllllllllllIlIIlIIlIllIIIll = MathHelper.parseIntWithDefault(llllllllllllllllIlIIlIIlIllIlIII[llllllllllllllllIlIIlIIlIllIIlIl++], llllllllllllllllIlIIlIIlIllIIIll);
            }
            llllllllllllllllIlIIlIIlIllIIllI.setBiome(llllllllllllllllIlIIlIIlIllIIIll);
            if (llllllllllllllllIlIIlIIlIllIIlll > 0 && llllllllllllllllIlIIlIIlIllIlIII.length > llllllllllllllllIlIIlIIlIllIIlIl) {
                final String[] llllllllllllllllIlIIlIIlIllIIIIl;
                final String[] llllllllllllllllIlIIlIIlIllIIIlI = llllllllllllllllIlIIlIIlIllIIIIl = llllllllllllllllIlIIlIIlIllIlIII[llllllllllllllllIlIIlIIlIllIIlIl++].toLowerCase().split(",");
                for (int llllllllllllllllIlIIlIIlIllIIIII = llllllllllllllllIlIIlIIlIllIIIlI.length, llllllllllllllllIlIIlIIlIlIlllll = 0; llllllllllllllllIlIIlIIlIlIlllll < llllllllllllllllIlIIlIIlIllIIIII; ++llllllllllllllllIlIIlIIlIlIlllll) {
                    final String llllllllllllllllIlIIlIIlIlIllllI = llllllllllllllllIlIIlIIlIllIIIIl[llllllllllllllllIlIIlIIlIlIlllll];
                    final String[] llllllllllllllllIlIIlIIlIlIlllIl = llllllllllllllllIlIIlIIlIlIllllI.split("\\(", 2);
                    final HashMap llllllllllllllllIlIIlIIlIlIlllII = Maps.newHashMap();
                    if (llllllllllllllllIlIIlIIlIlIlllIl[0].length() > 0) {
                        llllllllllllllllIlIIlIIlIllIIllI.getWorldFeatures().put(llllllllllllllllIlIIlIIlIlIlllIl[0], llllllllllllllllIlIIlIIlIlIlllII);
                        if (llllllllllllllllIlIIlIIlIlIlllIl.length > 1 && llllllllllllllllIlIIlIIlIlIlllIl[1].endsWith(")") && llllllllllllllllIlIIlIIlIlIlllIl[1].length() > 1) {
                            final String[] llllllllllllllllIlIIlIIlIlIllIll = llllllllllllllllIlIIlIIlIlIlllIl[1].substring(0, llllllllllllllllIlIIlIIlIlIlllIl[1].length() - 1).split(" ");
                            for (int llllllllllllllllIlIIlIIlIlIllIlI = 0; llllllllllllllllIlIIlIIlIlIllIlI < llllllllllllllllIlIIlIIlIlIllIll.length; ++llllllllllllllllIlIIlIIlIlIllIlI) {
                                final String[] llllllllllllllllIlIIlIIlIlIllIIl = llllllllllllllllIlIIlIIlIlIllIll[llllllllllllllllIlIIlIIlIlIllIlI].split("=", 2);
                                if (llllllllllllllllIlIIlIIlIlIllIIl.length == 2) {
                                    llllllllllllllllIlIIlIIlIlIlllII.put(llllllllllllllllIlIIlIIlIlIllIIl[0], llllllllllllllllIlIIlIIlIlIllIIl[1]);
                                }
                            }
                        }
                    }
                }
            }
            else {
                llllllllllllllllIlIIlIIlIllIIllI.getWorldFeatures().put("village", Maps.newHashMap());
            }
            return llllllllllllllllIlIIlIIlIllIIllI;
        }
        return getDefaultFlatGenerator();
    }
    
    public int getBiome() {
        return this.biomeToUse;
    }
    
    @Override
    public String toString() {
        final StringBuilder llllllllllllllllIlIIlIIlllIIIlII = new StringBuilder();
        llllllllllllllllIlIIlIIlllIIIlII.append(3);
        llllllllllllllllIlIIlIIlllIIIlII.append(";");
        for (int llllllllllllllllIlIIlIIlllIIIIll = 0; llllllllllllllllIlIIlIIlllIIIIll < this.flatLayers.size(); ++llllllllllllllllIlIIlIIlllIIIIll) {
            if (llllllllllllllllIlIIlIIlllIIIIll > 0) {
                llllllllllllllllIlIIlIIlllIIIlII.append(",");
            }
            llllllllllllllllIlIIlIIlllIIIlII.append(this.flatLayers.get(llllllllllllllllIlIIlIIlllIIIIll).toString());
        }
        llllllllllllllllIlIIlIIlllIIIlII.append(";");
        llllllllllllllllIlIIlIIlllIIIlII.append(this.biomeToUse);
        if (!this.worldFeatures.isEmpty()) {
            llllllllllllllllIlIIlIIlllIIIlII.append(";");
            int llllllllllllllllIlIIlIIlllIIIIll = 0;
            for (final Map.Entry llllllllllllllllIlIIlIIlllIIIIIl : this.worldFeatures.entrySet()) {
                if (llllllllllllllllIlIIlIIlllIIIIll++ > 0) {
                    llllllllllllllllIlIIlIIlllIIIlII.append(",");
                }
                llllllllllllllllIlIIlIIlllIIIlII.append(llllllllllllllllIlIIlIIlllIIIIIl.getKey().toLowerCase());
                final Map llllllllllllllllIlIIlIIlllIIIIII = llllllllllllllllIlIIlIIlllIIIIIl.getValue();
                if (!llllllllllllllllIlIIlIIlllIIIIII.isEmpty()) {
                    llllllllllllllllIlIIlIIlllIIIlII.append("(");
                    int llllllllllllllllIlIIlIIllIllllll = 0;
                    for (final Map.Entry llllllllllllllllIlIIlIIllIllllIl : llllllllllllllllIlIIlIIlllIIIIII.entrySet()) {
                        if (llllllllllllllllIlIIlIIllIllllll++ > 0) {
                            llllllllllllllllIlIIlIIlllIIIlII.append(" ");
                        }
                        llllllllllllllllIlIIlIIlllIIIlII.append(llllllllllllllllIlIIlIIllIllllIl.getKey());
                        llllllllllllllllIlIIlIIlllIIIlII.append("=");
                        llllllllllllllllIlIIlIIlllIIIlII.append(llllllllllllllllIlIIlIIllIllllIl.getValue());
                    }
                    llllllllllllllllIlIIlIIlllIIIlII.append(")");
                }
            }
        }
        else {
            llllllllllllllllIlIIlIIlllIIIlII.append(";");
        }
        return String.valueOf(llllllllllllllllIlIIlIIlllIIIlII);
    }
    
    public Map getWorldFeatures() {
        return this.worldFeatures;
    }
    
    private static FlatLayerInfo func_180715_a(final int llllllllllllllllIlIIlIIllIlIlIll, final String llllllllllllllllIlIIlIIllIIlllll, final int llllllllllllllllIlIIlIIllIIllllI) {
        String[] llllllllllllllllIlIIlIIllIlIlIII = (llllllllllllllllIlIIlIIllIlIlIll >= 3) ? llllllllllllllllIlIIlIIllIIlllll.split("\\*", 2) : llllllllllllllllIlIIlIIllIIlllll.split("x", 2);
        int llllllllllllllllIlIIlIIllIlIIlll = 1;
        int llllllllllllllllIlIIlIIllIlIIllI = 0;
        if (llllllllllllllllIlIIlIIllIlIlIII.length == 2) {
            try {
                llllllllllllllllIlIIlIIllIlIIlll = Integer.parseInt(llllllllllllllllIlIIlIIllIlIlIII[0]);
                if (llllllllllllllllIlIIlIIllIIllllI + llllllllllllllllIlIIlIIllIlIIlll >= 256) {
                    llllllllllllllllIlIIlIIllIlIIlll = 256 - llllllllllllllllIlIIlIIllIIllllI;
                }
                if (llllllllllllllllIlIIlIIllIlIIlll < 0) {
                    llllllllllllllllIlIIlIIllIlIIlll = 0;
                }
            }
            catch (Throwable llllllllllllllllIlIIlIIllIlIIlIl) {
                return null;
            }
        }
        Block llllllllllllllllIlIIlIIllIlIIlII = null;
        try {
            final String llllllllllllllllIlIIlIIllIlIIIll = llllllllllllllllIlIIlIIllIlIlIII[llllllllllllllllIlIIlIIllIlIlIII.length - 1];
            if (llllllllllllllllIlIIlIIllIlIlIll < 3) {
                llllllllllllllllIlIIlIIllIlIlIII = llllllllllllllllIlIIlIIllIlIIIll.split(":", 2);
                if (llllllllllllllllIlIIlIIllIlIlIII.length > 1) {
                    llllllllllllllllIlIIlIIllIlIIllI = Integer.parseInt(llllllllllllllllIlIIlIIllIlIlIII[1]);
                }
                llllllllllllllllIlIIlIIllIlIIlII = Block.getBlockById(Integer.parseInt(llllllllllllllllIlIIlIIllIlIlIII[0]));
            }
            else {
                llllllllllllllllIlIIlIIllIlIlIII = llllllllllllllllIlIIlIIllIlIIIll.split(":", 3);
                llllllllllllllllIlIIlIIllIlIIlII = ((llllllllllllllllIlIIlIIllIlIlIII.length > 1) ? Block.getBlockFromName(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllIlIIlIIllIlIlIII[0])).append(":").append(llllllllllllllllIlIIlIIllIlIlIII[1]))) : null);
                if (llllllllllllllllIlIIlIIllIlIIlII != null) {
                    llllllllllllllllIlIIlIIllIlIIllI = ((llllllllllllllllIlIIlIIllIlIlIII.length > 2) ? Integer.parseInt(llllllllllllllllIlIIlIIllIlIlIII[2]) : 0);
                }
                else {
                    llllllllllllllllIlIIlIIllIlIIlII = Block.getBlockFromName(llllllllllllllllIlIIlIIllIlIlIII[0]);
                    if (llllllllllllllllIlIIlIIllIlIIlII != null) {
                        llllllllllllllllIlIIlIIllIlIIllI = ((llllllllllllllllIlIIlIIllIlIlIII.length > 1) ? Integer.parseInt(llllllllllllllllIlIIlIIllIlIlIII[1]) : 0);
                    }
                }
                if (llllllllllllllllIlIIlIIllIlIIlII == null) {
                    return null;
                }
            }
            if (llllllllllllllllIlIIlIIllIlIIlII == Blocks.air) {
                llllllllllllllllIlIIlIIllIlIIllI = 0;
            }
            if (llllllllllllllllIlIIlIIllIlIIllI < 0 || llllllllllllllllIlIIlIIllIlIIllI > 15) {
                llllllllllllllllIlIIlIIllIlIIllI = 0;
            }
        }
        catch (Throwable llllllllllllllllIlIIlIIllIlIIIlI) {
            return null;
        }
        final FlatLayerInfo llllllllllllllllIlIIlIIllIlIIIIl = new FlatLayerInfo(llllllllllllllllIlIIlIIllIlIlIll, llllllllllllllllIlIIlIIllIlIIlll, llllllllllllllllIlIIlIIllIlIIlII, llllllllllllllllIlIIlIIllIlIIllI);
        llllllllllllllllIlIIlIIllIlIIIIl.setMinY(llllllllllllllllIlIIlIIllIIllllI);
        return llllllllllllllllIlIIlIIllIlIIIIl;
    }
}
