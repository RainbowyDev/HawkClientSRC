package net.minecraft.entity.ai;

import net.minecraft.profiler.*;
import org.apache.logging.log4j.*;
import java.util.*;
import com.google.common.collect.*;

public class EntityAITasks
{
    private /* synthetic */ List taskEntries;
    private final /* synthetic */ Profiler theProfiler;
    private /* synthetic */ List executingTaskEntries;
    private /* synthetic */ int tickRate;
    private /* synthetic */ int tickCount;
    
    static {
        __OBFID = "CL_00001588";
        logger = LogManager.getLogger();
    }
    
    private boolean canUse(final EntityAITaskEntry llllllllllllllllIIIlIllIIIlIlIll) {
        for (final EntityAITaskEntry llllllllllllllllIIIlIllIIIlIllIl : this.taskEntries) {
            if (llllllllllllllllIIIlIllIIIlIllIl != llllllllllllllllIIIlIllIIIlIlIll) {
                if (llllllllllllllllIIIlIllIIIlIlIll.priority >= llllllllllllllllIIIlIllIIIlIllIl.priority) {
                    if (!this.areTasksCompatible(llllllllllllllllIIIlIllIIIlIlIll, llllllllllllllllIIIlIllIIIlIllIl) && this.executingTaskEntries.contains(llllllllllllllllIIIlIllIIIlIllIl)) {
                        return false;
                    }
                    continue;
                }
                else {
                    if (!llllllllllllllllIIIlIllIIIlIllIl.action.isInterruptible() && this.executingTaskEntries.contains(llllllllllllllllIIIlIllIIIlIllIl)) {
                        return false;
                    }
                    continue;
                }
            }
        }
        return true;
    }
    
    public void addTask(final int llllllllllllllllIIIlIllIIlIllllI, final EntityAIBase llllllllllllllllIIIlIllIIlIlllIl) {
        this.taskEntries.add(new EntityAITaskEntry(llllllllllllllllIIIlIllIIlIllllI, llllllllllllllllIIIlIllIIlIlllIl));
    }
    
    public void onUpdateTasks() {
        this.theProfiler.startSection("goalSetup");
        if (this.tickCount++ % this.tickRate == 0) {
            for (final EntityAITaskEntry llllllllllllllllIIIlIllIIlIIIIll : this.taskEntries) {
                final boolean llllllllllllllllIIIlIllIIlIIIIII = this.executingTaskEntries.contains(llllllllllllllllIIIlIllIIlIIIIll);
                if (llllllllllllllllIIIlIllIIlIIIIII) {
                    if (this.canUse(llllllllllllllllIIIlIllIIlIIIIll) && this.canContinue(llllllllllllllllIIIlIllIIlIIIIll)) {
                        continue;
                    }
                    llllllllllllllllIIIlIllIIlIIIIll.action.resetTask();
                    this.executingTaskEntries.remove(llllllllllllllllIIIlIllIIlIIIIll);
                }
                if (this.canUse(llllllllllllllllIIIlIllIIlIIIIll) && llllllllllllllllIIIlIllIIlIIIIll.action.shouldExecute()) {
                    llllllllllllllllIIIlIllIIlIIIIll.action.startExecuting();
                    this.executingTaskEntries.add(llllllllllllllllIIIlIllIIlIIIIll);
                }
            }
        }
        else {
            final Iterator llllllllllllllllIIIlIllIIlIIIlII = this.executingTaskEntries.iterator();
            while (llllllllllllllllIIIlIllIIlIIIlII.hasNext()) {
                final EntityAITaskEntry llllllllllllllllIIIlIllIIlIIIIlI = llllllllllllllllIIIlIllIIlIIIlII.next();
                if (!this.canContinue(llllllllllllllllIIIlIllIIlIIIIlI)) {
                    llllllllllllllllIIIlIllIIlIIIIlI.action.resetTask();
                    llllllllllllllllIIIlIllIIlIIIlII.remove();
                }
            }
        }
        this.theProfiler.endSection();
        this.theProfiler.startSection("goalTick");
        final Iterator llllllllllllllllIIIlIllIIlIIIlII = this.executingTaskEntries.iterator();
        while (llllllllllllllllIIIlIllIIlIIIlII.hasNext()) {
            final EntityAITaskEntry llllllllllllllllIIIlIllIIlIIIIIl = llllllllllllllllIIIlIllIIlIIIlII.next();
            llllllllllllllllIIIlIllIIlIIIIIl.action.updateTask();
        }
        this.theProfiler.endSection();
    }
    
    public EntityAITasks(final Profiler llllllllllllllllIIIlIllIIllIIIll) {
        this.taskEntries = Lists.newArrayList();
        this.executingTaskEntries = Lists.newArrayList();
        this.tickRate = 3;
        this.theProfiler = llllllllllllllllIIIlIllIIllIIIll;
    }
    
    public void removeTask(final EntityAIBase llllllllllllllllIIIlIllIIlIIlllI) {
        final Iterator llllllllllllllllIIIlIllIIlIlIIlI = this.taskEntries.iterator();
        while (llllllllllllllllIIIlIllIIlIlIIlI.hasNext()) {
            final EntityAITaskEntry llllllllllllllllIIIlIllIIlIlIIIl = llllllllllllllllIIIlIllIIlIlIIlI.next();
            final EntityAIBase llllllllllllllllIIIlIllIIlIlIIII = llllllllllllllllIIIlIllIIlIlIIIl.action;
            if (llllllllllllllllIIIlIllIIlIlIIII == llllllllllllllllIIIlIllIIlIIlllI) {
                if (this.executingTaskEntries.contains(llllllllllllllllIIIlIllIIlIlIIIl)) {
                    llllllllllllllllIIIlIllIIlIlIIII.resetTask();
                    this.executingTaskEntries.remove(llllllllllllllllIIIlIllIIlIlIIIl);
                }
                llllllllllllllllIIIlIllIIlIlIIlI.remove();
            }
        }
    }
    
    private boolean areTasksCompatible(final EntityAITaskEntry llllllllllllllllIIIlIllIIIlIIIll, final EntityAITaskEntry llllllllllllllllIIIlIllIIIlIIlII) {
        return (llllllllllllllllIIIlIllIIIlIIIll.action.getMutexBits() & llllllllllllllllIIIlIllIIIlIIlII.action.getMutexBits()) == 0x0;
    }
    
    private boolean canContinue(final EntityAITaskEntry llllllllllllllllIIIlIllIIIlllIII) {
        final boolean llllllllllllllllIIIlIllIIIllIlll = llllllllllllllllIIIlIllIIIlllIII.action.continueExecuting();
        return llllllllllllllllIIIlIllIIIllIlll;
    }
    
    class EntityAITaskEntry
    {
        public /* synthetic */ int priority;
        public /* synthetic */ EntityAIBase action;
        
        static {
            __OBFID = "CL_00001589";
        }
        
        public EntityAITaskEntry(final int lllllllllllllllIIlIllllIlIIIlIlI, final EntityAIBase lllllllllllllllIIlIllllIlIIIllIl) {
            this.priority = lllllllllllllllIIlIllllIlIIIlIlI;
            this.action = lllllllllllllllIIlIllllIlIIIllIl;
        }
    }
}
