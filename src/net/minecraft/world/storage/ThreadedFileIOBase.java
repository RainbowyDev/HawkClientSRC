package net.minecraft.world.storage;

import com.google.common.collect.*;
import java.util.*;

public class ThreadedFileIOBase implements Runnable
{
    private /* synthetic */ List threadedIOQueue;
    private volatile /* synthetic */ boolean isThreadWaiting;
    private volatile /* synthetic */ long writeQueuedCounter;
    private static final /* synthetic */ ThreadedFileIOBase threadedIOInstance;
    private volatile /* synthetic */ long savedIOCounter;
    
    public static ThreadedFileIOBase func_178779_a() {
        return ThreadedFileIOBase.threadedIOInstance;
    }
    
    private void processQueue() {
        for (int llllllllllllllllllllIlIllllIIlII = 0; llllllllllllllllllllIlIllllIIlII < this.threadedIOQueue.size(); ++llllllllllllllllllllIlIllllIIlII) {
            final IThreadedFileIO llllllllllllllllllllIlIllllIIIll = this.threadedIOQueue.get(llllllllllllllllllllIlIllllIIlII);
            final boolean llllllllllllllllllllIlIllllIIIlI = llllllllllllllllllllIlIllllIIIll.writeNextIO();
            if (!llllllllllllllllllllIlIllllIIIlI) {
                this.threadedIOQueue.remove(llllllllllllllllllllIlIllllIIlII--);
                ++this.savedIOCounter;
            }
            try {
                Thread.sleep(this.isThreadWaiting ? 0L : 10L);
            }
            catch (InterruptedException llllllllllllllllllllIlIllllIIIIl) {
                llllllllllllllllllllIlIllllIIIIl.printStackTrace();
            }
        }
        if (this.threadedIOQueue.isEmpty()) {
            try {
                Thread.sleep(25L);
            }
            catch (InterruptedException llllllllllllllllllllIlIllllIIIII) {
                llllllllllllllllllllIlIllllIIIII.printStackTrace();
            }
        }
    }
    
    public void queueIO(final IThreadedFileIO llllllllllllllllllllIlIlllIlIlll) {
        if (!this.threadedIOQueue.contains(llllllllllllllllllllIlIlllIlIlll)) {
            ++this.writeQueuedCounter;
            this.threadedIOQueue.add(llllllllllllllllllllIlIlllIlIlll);
        }
    }
    
    static {
        __OBFID = "CL_00000605";
        threadedIOInstance = new ThreadedFileIOBase();
    }
    
    @Override
    public void run() {
        while (true) {
            this.processQueue();
        }
    }
    
    public void waitForFinish() throws InterruptedException {
        this.isThreadWaiting = true;
        while (this.writeQueuedCounter != this.savedIOCounter) {
            Thread.sleep(10L);
        }
        this.isThreadWaiting = false;
    }
    
    private ThreadedFileIOBase() {
        this.threadedIOQueue = Collections.synchronizedList((List<Object>)Lists.newArrayList());
        final Thread llllllllllllllllllllIlIlllllIIII = new Thread(this, "File IO Thread");
        llllllllllllllllllllIlIlllllIIII.setPriority(1);
        llllllllllllllllllllIlIlllllIIII.start();
    }
}
