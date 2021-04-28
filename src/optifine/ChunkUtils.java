package optifine;

import java.lang.reflect.*;
import net.minecraft.world.chunk.*;
import java.util.*;

public class ChunkUtils
{
    private static /* synthetic */ boolean fieldHasEntitiesMissing;
    private static /* synthetic */ Field fieldHasEntities;
    
    private static Field findFieldHasEntities(final Chunk llllllllllllllIlllIllIlIlIllllII) {
        try {
            final ArrayList llllllllllllllIlllIllIlIlIlllIll = new ArrayList();
            final ArrayList llllllllllllllIlllIllIlIlIlllIlI = new ArrayList();
            final Field[] llllllllllllllIlllIllIlIlIlllIIl = Chunk.class.getDeclaredFields();
            for (int llllllllllllllIlllIllIlIlIlllIII = 0; llllllllllllllIlllIllIlIlIlllIII < llllllllllllllIlllIllIlIlIlllIIl.length; ++llllllllllllllIlllIllIlIlIlllIII) {
                final Field llllllllllllllIlllIllIlIlIllIlll = llllllllllllllIlllIllIlIlIlllIIl[llllllllllllllIlllIllIlIlIlllIII];
                if (llllllllllllllIlllIllIlIlIllIlll.getType() == Boolean.TYPE) {
                    llllllllllllllIlllIllIlIlIllIlll.setAccessible(true);
                    llllllllllllllIlllIllIlIlIlllIll.add(llllllllllllllIlllIllIlIlIllIlll);
                    llllllllllllllIlllIllIlIlIlllIlI.add(llllllllllllllIlllIllIlIlIllIlll.get(llllllllllllllIlllIllIlIlIllllII));
                }
            }
            llllllllllllllIlllIllIlIlIllllII.setHasEntities(false);
            final ArrayList llllllllllllllIlllIllIlIlIllIllI = new ArrayList();
            for (final Field llllllllllllllIlllIllIlIlIllIlII : llllllllllllllIlllIllIlIlIlllIll) {
                llllllllllllllIlllIllIlIlIllIllI.add(llllllllllllllIlllIllIlIlIllIlII.get(llllllllllllllIlllIllIlIlIllllII));
            }
            llllllllllllllIlllIllIlIlIllllII.setHasEntities(true);
            final ArrayList llllllllllllllIlllIllIlIlIllIIll = new ArrayList();
            for (final Field llllllllllllllIlllIllIlIlIllIIIl : llllllllllllllIlllIllIlIlIlllIll) {
                llllllllllllllIlllIllIlIlIllIIll.add(llllllllllllllIlllIllIlIlIllIIIl.get(llllllllllllllIlllIllIlIlIllllII));
            }
            final ArrayList llllllllllllllIlllIllIlIlIlIllll = new ArrayList();
            for (int llllllllllllllIlllIllIlIlIlIlllI = 0; llllllllllllllIlllIllIlIlIlIlllI < llllllllllllllIlllIllIlIlIlllIll.size(); ++llllllllllllllIlllIllIlIlIlIlllI) {
                final Field llllllllllllllIlllIllIlIlIlIllIl = llllllllllllllIlllIllIlIlIlllIll.get(llllllllllllllIlllIllIlIlIlIlllI);
                final Boolean llllllllllllllIlllIllIlIlIlIllII = llllllllllllllIlllIllIlIlIllIllI.get(llllllllllllllIlllIllIlIlIlIlllI);
                final Boolean llllllllllllllIlllIllIlIlIlIlIll = llllllllllllllIlllIllIlIlIllIIll.get(llllllllllllllIlllIllIlIlIlIlllI);
                if (!llllllllllllllIlllIllIlIlIlIllII && llllllllllllllIlllIllIlIlIlIlIll) {
                    llllllllllllllIlllIllIlIlIlIllll.add(llllllllllllllIlllIllIlIlIlIllIl);
                    final Boolean llllllllllllllIlllIllIlIlIlIlIlI = llllllllllllllIlllIllIlIlIlllIlI.get(llllllllllllllIlllIllIlIlIlIlllI);
                    llllllllllllllIlllIllIlIlIlIllIl.set(llllllllllllllIlllIllIlIlIllllII, llllllllllllllIlllIllIlIlIlIlIlI);
                }
            }
            if (llllllllllllllIlllIllIlIlIlIllll.size() == 1) {
                final Field llllllllllllllIlllIllIlIlIllIIII = llllllllllllllIlllIllIlIlIlIllll.get(0);
                return llllllllllllllIlllIllIlIlIllIIII;
            }
        }
        catch (Exception llllllllllllllIlllIllIlIlIlIlIIl) {
            Config.warn(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIllIlIlIlIlIIl.getClass().getName())).append(" ").append(llllllllllllllIlllIllIlIlIlIlIIl.getMessage())));
        }
        Config.warn("Error finding Chunk.hasEntities");
        return null;
    }
    
    public static boolean hasEntities(final Chunk llllllllllllllIlllIllIlIllIIllll) {
        if (ChunkUtils.fieldHasEntities == null) {
            if (ChunkUtils.fieldHasEntitiesMissing) {
                return true;
            }
            ChunkUtils.fieldHasEntities = findFieldHasEntities(llllllllllllllIlllIllIlIllIIllll);
            if (ChunkUtils.fieldHasEntities == null) {
                return ChunkUtils.fieldHasEntitiesMissing = true;
            }
        }
        try {
            return ChunkUtils.fieldHasEntities.getBoolean(llllllllllllllIlllIllIlIllIIllll);
        }
        catch (Exception llllllllllllllIlllIllIlIllIIlllI) {
            Config.warn("Error calling Chunk.hasEntities");
            Config.warn(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIllIlIllIIlllI.getClass().getName())).append(" ").append(llllllllllllllIlllIllIlIllIIlllI.getMessage())));
            return ChunkUtils.fieldHasEntitiesMissing = true;
        }
    }
    
    static {
        ChunkUtils.fieldHasEntities = null;
        ChunkUtils.fieldHasEntitiesMissing = false;
    }
}
