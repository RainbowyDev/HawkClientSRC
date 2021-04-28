package net.minecraft.world;

import net.minecraft.server.*;
import net.minecraft.profiler.*;
import net.minecraft.world.storage.*;
import net.minecraft.world.border.*;
import net.minecraft.village.*;

public class WorldServerMulti extends WorldServer
{
    private /* synthetic */ WorldServer delegate;
    
    static {
        __OBFID = "CL_00001430";
    }
    
    @Override
    protected void saveLevel() throws MinecraftException {
    }
    
    public WorldServerMulti(final MinecraftServer llllllllllllllllIllIlIllIlIllIII, final ISaveHandler llllllllllllllllIllIlIllIlIlIlll, final int llllllllllllllllIllIlIllIlIlIllI, final WorldServer llllllllllllllllIllIlIllIlIIllll, final Profiler llllllllllllllllIllIlIllIlIlIlII) {
        super(llllllllllllllllIllIlIllIlIllIII, llllllllllllllllIllIlIllIlIlIlll, new DerivedWorldInfo(llllllllllllllllIllIlIllIlIIllll.getWorldInfo()), llllllllllllllllIllIlIllIlIlIllI, llllllllllllllllIllIlIllIlIlIlII);
        this.delegate = llllllllllllllllIllIlIllIlIIllll;
        llllllllllllllllIllIlIllIlIIllll.getWorldBorder().addListener(new IBorderListener() {
            static {
                __OBFID = "CL_00002273";
            }
            
            @Override
            public void onCenterChanged(final WorldBorder llllllllllllllIIIlIlIlllllllllIl, final double llllllllllllllIIIlIlIllllllllIIl, final double llllllllllllllIIIlIlIllllllllIII) {
                WorldServerMulti.this.getWorldBorder().setCenter(llllllllllllllIIIlIlIllllllllIIl, llllllllllllllIIIlIlIllllllllIII);
            }
            
            @Override
            public void onSizeChanged(final WorldBorder llllllllllllllIIIlIllIIIIIIlIIlI, final double llllllllllllllIIIlIllIIIIIIlIIIl) {
                WorldServerMulti.this.getWorldBorder().setTransition(llllllllllllllIIIlIllIIIIIIlIIIl);
            }
            
            @Override
            public void onWarningTimeChanged(final WorldBorder llllllllllllllIIIlIlIlllllllIlII, final int llllllllllllllIIIlIlIlllllllIIll) {
                WorldServerMulti.this.getWorldBorder().setWarningTime(llllllllllllllIIIlIlIlllllllIIll);
            }
            
            @Override
            public void func_177696_b(final WorldBorder llllllllllllllIIIlIlIllllllIIllI, final double llllllllllllllIIIlIlIllllllIIlIl) {
                WorldServerMulti.this.getWorldBorder().func_177744_c(llllllllllllllIIIlIlIllllllIIlIl);
            }
            
            @Override
            public void func_177695_c(final WorldBorder llllllllllllllIIIlIlIlllllIlllll, final double llllllllllllllIIIlIlIlllllIllllI) {
                WorldServerMulti.this.getWorldBorder().setDamageBuffer(llllllllllllllIIIlIlIlllllIllllI);
            }
            
            @Override
            public void onWarningDistanceChanged(final WorldBorder llllllllllllllIIIlIlIllllllIllIl, final int llllllllllllllIIIlIlIllllllIlIlI) {
                WorldServerMulti.this.getWorldBorder().setWarningDistance(llllllllllllllIIIlIlIllllllIlIlI);
            }
            
            @Override
            public void func_177692_a(final WorldBorder llllllllllllllIIIlIllIIIIIIIlIIl, final double llllllllllllllIIIlIllIIIIIIIlIII, final double llllllllllllllIIIlIllIIIIIIIIlll, final long llllllllllllllIIIlIllIIIIIIIIllI) {
                WorldServerMulti.this.getWorldBorder().setTransition(llllllllllllllIIIlIllIIIIIIIlIII, llllllllllllllIIIlIllIIIIIIIIlll, llllllllllllllIIIlIllIIIIIIIIllI);
            }
        });
    }
    
    @Override
    public World init() {
        this.mapStorage = this.delegate.func_175693_T();
        this.worldScoreboard = this.delegate.getScoreboard();
        final String llllllllllllllllIllIlIllIlIIlIII = VillageCollection.func_176062_a(this.provider);
        final VillageCollection llllllllllllllllIllIlIllIlIIIlll = (VillageCollection)this.mapStorage.loadData(VillageCollection.class, llllllllllllllllIllIlIllIlIIlIII);
        if (llllllllllllllllIllIlIllIlIIIlll == null) {
            this.villageCollectionObj = new VillageCollection(this);
            this.mapStorage.setData(llllllllllllllllIllIlIllIlIIlIII, this.villageCollectionObj);
        }
        else {
            this.villageCollectionObj = llllllllllllllllIllIlIllIlIIIlll;
            this.villageCollectionObj.func_82566_a(this);
        }
        return this;
    }
}
